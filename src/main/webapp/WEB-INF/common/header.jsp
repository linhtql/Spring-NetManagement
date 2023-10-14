<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home Page</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Add
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/add-device">Add device</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/add-customer">Add customer</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/add-service">Add service</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        View
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/list-device/page=1">List device</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/list-customer">List customer</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/list-service">List service</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Register
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/register-use-device">Register device</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/register-use-service">Register service</a>
                    </div>
                </li>
                <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/statistic">Statistic</a>
                </li>
            </ul>
        </div>
    </nav>
</header>