<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

db user context param value :: ${initParam.dbuser}<br>
db pwd context param value :: ${initParam.dbpwd}<br>

Cookie name :: ${cookie.JSESSIONID.name} <br>
Session id(cookie value):: ${cookie.JSESSIONID.value} <br>

uname req param value :: ${param.uname} <br>

All req param values :: ${paramValues.uname[1]},
                                          ${paramValues.pwd[0] }  <br>
user-agent req header value :: ${header['user-agent']} <br>
all values of accept req header
  ${headerValues.accept[0]}
                                          

