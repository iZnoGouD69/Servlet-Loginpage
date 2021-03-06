<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link rel="preconnect"
href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"
rel="stylesheet">
</head>

<style>
	*{
  margin:0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

html{
  background-image: url("blackhole.jpg");
  background-color : lightblue; 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 800px;
 }


body{
  display: grid;
  place-items: center;
  text-align: center;
  background-size: cover;
}

.content{
  width: 500px; 
  height: 500px;
  border-radius: 10px;
  padding: 40px 30px;
  margin-top: 100px;
  background-color: #00000008;
  box-shadow: -3px -3px 30px #000000,
              3px 3px 30px rgb(0, 0, 0);
 
}

form h3{
    font-size: 50px;
    font-weight: 500;
    line-height: 42px;
    text-align: center;
    color: #000000
}

label{
    display: block;
    margin-top: 5px;
    font-size: 25px;
    font-weight: 500;
}

input{
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgb(255 255 255 / 50%);
    border-radius: 50px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
}
::placeholder{
    color: #000000;
}

button{
    margin-top: 20px;
    width: 100%;
    background-color: #ffffff;
    color: #080710;
    padding: 15px 0;
    font-size: 18px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
}

.social{
  margin-top: 10px;
  display: flex;
}
.social div{
  background: red;
  width: 150px;
  border-radius: 10px;
  padding: 5px 10px 10px 5px;
  background-color: rgba(255,255,255,0.27);
  color: #000000;
  text-align: center;
  margin-left:300px
} 
.social div:hover{
  background-color: rgba(255,255,255,0.47);
}
.social .fb{
  margin-left: 25px;
}
.social i{
  margin-right: 4px;
}

.fa-user-plus{
  color: black;
}

</style>
<body>
 <div align="right" class="wrapper">
    <div align="left" class="content">
    	<form action="login" method="post"> 
    	
    	    <h3>Note-it-down</h3>  
    	    <br>
    	    
    	    <label for="username">Username:  </label> 
       		<input type="text" placeholder="Enter Username here" name="username">
       		    	    
    	    <label for="password">Password:  </label>
        	<input type="password" placeholder="Enter Password here" name="password">
			<button>Log In</button>
			${errorMsg}
			
			<div  class="social">
          		<div onclick="window.location.href='registration.jsp'" class="go"><i class="fas fa-user-plus"></i>New User?</div>
        	</div>

 		</form>
 	</div>
</div>            
</body>
</html>