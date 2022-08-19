$(document).ready(function (){
      alert("en el btn");
        consultarusuario();
      
      
    $('.btninsertar').on('click',function(){
        alert("hola");
      
        insertar();
    });
    
    
    
    
    function  insertar(){
        
        let doc=$('.doc').val();
        let usu=$('.usu').val();
        let cla=$('.cla').val();
        let rol=$('.rol').val();
        let est=$('.est').val();
        
        alert(doc+usu+cla+rol+est);
        $.ajax({
            type:"post",
            url:"ServletConsultajavascript",
            data:{
                d:doc,u:usu,c:cla,r:rol,e:est
            }
        });
        
    }
    
    
    
    
    function  consultarusuario(){
        
        alert("en la funcion");
        
       $.ajax({
           url:"ServletConsultajavascript",
            dataType: 'json',
            success:function (datos){
                //console.log(datos)
                
             let tabla=document.getElementById('tabla');
             tabla.innerHTML='';
             var dat=datos.length;
             if(dat>0){
                 tabla.innerHTML=`<tr>
                                  <th>Documento</th>
                                  <th>Usuario</th>
                                  <th>Clace</th>
                                  <th>rol</th>
                                  <th>Estado</th>
                                  <th>Imagen</th>
                                 </tr> `;
                    for(var i of datos){
                        tabla.innerHTML+=`<tr>
                                  <td>${i.documento}</td>
                                  <td>${i.usuario}</td>
                                  <td>${i.clave}</td>
                                  <td>${i.estado}</td>
                                  <td>${i.rol}</td>
                                  </tr> `;
                    }
                }
                
            }
            
       }) ;
        
    }
    
 
});


