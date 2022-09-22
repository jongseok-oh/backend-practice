<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	
	<br>
	<br>
	<br>
	<section class="vh-100">
	  <div class="container-fluid h-custom">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-md-9 col-lg-6 col-xl-5">
	        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
	          class="img-fluid" alt="Sample image">
	      </div>
	      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
	        <form action = "${root}/user/login.do" method = "post">
	          <!-- Email input -->
	          <div class="form-outline mb-4">
	            <input type="text" id="form3Example3" class="form-control form-control-lg"
	              placeholder="Enter a valid email address" name = "userId"/>
	            <label class="form-label" for="form3Example3">User ID</label>
	          </div>
	
	          <!-- Password input -->
	          <div class="form-outline mb-3">
	            <input type="password" id="form3Example4" class="form-control form-control-lg"
	              placeholder="Enter password" name = "passWord"/>
	            <label class="form-label" for="form3Example4">Password</label>
	          </div>
	
	          <div class="d-flex justify-content-between align-items-center">
	            <!-- Checkbox -->
	            <div class="form-check mb-0">
	              <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
	              <label class="form-check-label" for="form2Example3">
	                Remember me
	              </label>
	            </div>
	            <a href="#!" class="text-body">Forgot password?</a>
	          </div>
	
	          <div class="text-center text-lg-start mt-4 pt-2">
	            <button type="submit" class="btn btn-primary btn-lg"
	              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
	            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="${root}/user/signup.jsp"
	                class="link-danger">Register</a></p>
	          </div>
	
	        </form>
	      </div>
	    </div>
	  </div>
	</section>

<%@ include file="/include/footer.jsp" %>