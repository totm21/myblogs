<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="footer_bg" id="contact"><!-- start footer -->
<div class="container">
	<div class="row footer">
		<div class="col-md-8 contact_left">
			<h3>get in touch</h3>
			<p>In order to get in touch use the contact form below:</h4>
			<form method="post" action="contact-post.html">
				<input type="text" value="Name (Required)" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name';}">
				<input type="text" value="Email (Required)" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}">
				<input type="text" value="Subject" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Subject';}">
				<textarea onFocus="if(this.value == 'Your Message here....') this.value='';" onBlur="if(this.value == '') this.value='Your Message here....;" >Your Message here....</textarea>
				<span class="pull-right"><input type="submit" value="submit us"></span>
			</form>
		</div>
		<div class="col-md-4  contact_right">
			<p><span>Lorem Ipsum is simply dummy text: </span> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. </p>
			<ul class="list-unstyled address">
				<li><i class="fa fa-map-marker"></i><span>500 Lorem Ipsum Dolor Sit,</span></li>
				<li><i class="fa fa-phone"></i><span>(00) 222 666 444</span></li>
				<li><i class="fa fa-envelope"></i><a href="mailto:info@mycompany.com">info(at)mycompany.com</a></li>
			</ul>
		</div>		
	</div>
</div>
</div>