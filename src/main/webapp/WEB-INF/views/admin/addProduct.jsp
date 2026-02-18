<!DOCTYPE html>
<html lang="en">

    <%@ include file="admin_header.jsp" %>

    <!-- ***** Registration Area Starts ***** -->
    <br><br><br>
    <div class="contact-us">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                
                    <form id="contact" action="/admin/addProduct" method="post" enctype="multipart/form-data">
                        <!-- <div class="row"> -->
                          <div class="col-lg-12">
                            <fieldset>
                              <input name="image" type="file" id="name" placeholder="Choose Product File" required="">
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                              <input name="imgName" type="text" id="name" placeholder="Enter Image Name" required="">
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                              <input name="desc" type="text" id="name" placeholder="Enter Product Description" required="" maxlength="100">
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                             <!--   <input name="type" type="text"  id="name" placeholder="Enter Product Type" required="">-->
							<select name="type" required>
									<option selected="selected" disabled="disabled" >Select Product Type</option>
									<option>Men's</option>
									<option>Women's</option>
									<option>Kid's</option>
								
							</select>
							
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                              <input name="status" type="text" id="name" placeholder="Enter Product Status" required="">
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                              <input name="price" type="text" id="name" placeholder="Enter Prodcut Price" step="0.01"  required="">
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                              <input name="qty" type="text" id="name" placeholder="Enter Prodcut Quantity" step="0.01"  required="">
                            </fieldset>
                          </div><br><br>
                          <div class="col-lg-12">
                            <fieldset>
                              <input type="submit" id="form-submit" class="main-dark-button" value="Submit">
                            </fieldset>
                          </div>
                       <!--  </div> -->
                      </form>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** Registration Area Ends ***** -->
    

  </body>

</html>
