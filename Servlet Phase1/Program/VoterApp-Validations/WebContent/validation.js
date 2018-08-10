function validation(frm){
	  alert("client side form validations..")
	  //change vflag value to "yes" indicating Client Side form validations are done
	  frm.vflag.value="yes";
	  //Empty the form validation error messages 
	  document.getElementById("nameErr").innerHTML="";
	  document.getElementById("ageErr").innerHTML="";
	   //read form data
	 var name=frm.pname.value;
	  var age=frm.page.value;
	  //write client side form validation logic
	  if(name==""){
		  document.getElementById("nameErr").innerHTML="<i>name is required</i>";
		  frm.pname.focus();
		  return false;
	  }
	  
	  if(age==""){
		  document.getElementById("ageErr").innerHTML="<i>age is required</i>";
		  frm.page.focus();
		  return false;
	  }
	  else if(isNaN(age)){
		  document.getElementById("ageErr").innerHTML="<i>age must be numberic value</i>";
		  frm.page.focus();
		  return false;
	  }//else if
	  else{
		  if(age<=0 || age>125){
			  document.getElementById("ageErr").innerHTML="<i>age must be in the range of 1-125 </i>";
			  frm.page.focus();
			  return false;
		  }//if
	  }//else
		  return true; 
  }//function