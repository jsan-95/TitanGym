    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>PlayFit</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/PlayFitHeroku/Main/Styles.css">
    <link rel="stylesheet" href="data/font-awesome-4.7.0/css/font-awesome.min.css">

    <script src="http://code.jquery.com/jquery-latest.js">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<body>
    <header>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <!-- Brand -->
        <a class="navbar-brand" href="/PlayFitHeroku/index.jsp">PLAYFIT</a>
        <%  if (session.getAttribute("username") == null) {%>
        <div class="collapse navbar-collapse justify-content-end" id="nav-content">   
            <ul class="navbar-nav">
                <li class="nav-item">
                <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="dropdown order-1">
                    <button type="button" id="dropdownMenu1" data-toggle="dropdown" class="btn btn-outline-secondary dropdown-toggle">Iniciar sesión <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-menu-right mt-1">
                      <li class="p-3">
                            <form class="form" role="form" action="/PlayFitHeroku/FrontController" method="Post">
                                <div class="form-group">
                                    <input id="emailInput" name='username' placeholder="Email" class="form-control form-control-sm" type="text" required="">
                                    <input type='hidden' name='command' value='RegisterCommand'>
                                </div>
                                <div class="form-group">
                                    <input id="passwordInput" name='password' type = "password" placeholder="Password" class="form-control form-control-sm"  required="">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                                </div>
                                <div class="form-group text-xs-center">
                                    <small><a href="#">Forgot password?</a></small>
                                </div>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
                </li>
            </ul>
        </div>
        <% } else {%>
        
        <div class="collapse navbar-collapse justify-content-end" id="nav-content">   
            <ul class="navbar-nav">
                <li class="nav-item">
                <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="dropdown order-1">
                <form class="form" role="form" action="/PlayFitHeroku/FrontController" method="Post">
                    <a href="/PlayFitHeroku/ControllerPages/Perfil.jsp" class="text-light padding-right">¡Bienvenido, <%=session.getAttribute("username")%>! </a>
                    <input type='hidden' name='command' value='InvalidateSessionCommand'>
                    <input class="btn btn-outline-secondary dropdown-toggle" type='submit' value='Cerrar sesión'>
                </form>

                </li>
            </ul>
                </li>
            </ul>
        </div>
        
        <%}%>
        </nav>
        
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
         
        <!-- Brand -->
        <a class="navbar-brand" href="#">Logo</a>

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#conocenos">Conócenos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#horario">Horario</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#cuotas">Cuotas</a>
            </li>
            <!-- Dropdown -->
            <li class="nav-item ">
                <a class="nav-link" href="#activities" id="navbardrop" >Actividades</a>
            </li>
        </ul>
        </nav>
    </header>

