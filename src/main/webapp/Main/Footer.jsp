
<%
   
    if(session.getAttribute("errorMessage")!= null){
        %>
        <script type="text/javascript">
            alert("Algunos de los datos introducidos no son correctos."); 
        </script> 
<%
    }
%>
<br>
<div class="container-fluid bg-dark" id="conocenos">
    <br>
    <br>
    <h1 class="text-center" style="color:white">Conócenos</h1>
	<div class="row">
        <div class="col">
        	<iframe width="100%" width="350" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="20" src="https://maps.google.co.uk/maps?f=q&source=s_q&hl=en&geocode=&q=15+Springfield+Way,+Hythe,+CT21+5SH&aq=t&sll=52.8382,-2.327815&sspn=8.047465,13.666992&ie=UTF8&hq=&hnear=15+Springfield+Way,+Hythe+CT21+5SH,+United+Kingdom&t=m&z=14&ll=51.077429,1.121722&output=embed"></iframe>
    	</div>
    	
      	<div class="col text-center" style="color:white">
            <br>
            <br>
            <h2>PlayFIt</h2>
    		<address>
    			<strong>Hythe Window Cleaning</strong><br>
    			15 Springfield Way<br>
    			Hythe<br>
    			Kent<br>
    			United Kingdon<br>
    			CT21 5SH<br>
    			<abbr title="Phone">Tlf:</abbr> 928 333 333
    		</address>
    	</div>
        <div class="col" style="color:white">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="well well-sm">
                            <form class="form-horizontal" method="get" action="/PlayFitHeroku/FrontController">
                                <fieldset>
                                    <legend class="text-center header">Contacto</legend>

                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                        <div class="col-md-12">
                                            <input id="email" name="email" type="text" placeholder="Dirección de correo electrónico" class="form-control">
                                        </div>
                                    </div>
   
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                        <div class="col-md-12">
                                            <input class="form-control" id="subject" name="subject" placeholder="Introuce el asunto del mensaje aquí">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-pencil-square-o bigicon"></i></span>
                                        <div class="col-md-12">
                                            <textarea class="form-control" id="message" name="message" placeholder="Introuce tu mensaje aquí. Te responderemos en menos de 2 días." rows="4"></textarea>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-md-12 text-center">
                                            <input  type="hidden" name="command" value="EmailCommand" >
                                            <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
</div>

