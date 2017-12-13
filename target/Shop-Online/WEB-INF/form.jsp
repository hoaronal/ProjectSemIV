<%--
  Created by IntelliJ IDEA.
  User: HoaRonal
  Date: 11/27/2017
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form  id="myform" action="/quan-tri/nguoi-dung/them-moi/luu" method="POST" commandName="user">
                <table>
                    <tr> <td>User Name:</td> <td><form:input  path="username"/><form:errors path="username" cssClass="error-msg"/> </td> </tr>
                    <tr> <td>Password:</td> <td><form:password path="password"/><form:errors path="password" cssClass="error-msg"/> </td> </tr>
                    </form:form>

                    <form method="get" action="http://demos.creative-tim.com/" class="form-horizontal">
                        <div class="card-header card-header-text" data-background-color="rose">
                            <h4 class="card-title">Input Variants</h4>
                        </div>
                        <div class="card-content">
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Custom Checkboxes &amp; radios</label>
                                <div class="col-sm-4 col-sm-offset-1 checkbox-radios">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes"><span class="checkbox-material"><span class="check"></span></span> Unchecked
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes" checked=""><span class="checkbox-material"><span class="check"></span></span> Checked
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes" disabled=""><span class="checkbox-material"><span class="check"></span></span> Disabled Unchecked
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes" checked="" disabled=""><span class="checkbox-material"><span class="check"></span></span> Disabled Checked
                                        </label>
                                    </div>
                                </div>
                                <div class="col-sm-5 checkbox-radios">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios"><span class="circle"></span><span class="check"></span> Radio is off
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" checked="true"><span class="circle"></span><span class="check"></span> Radio is on
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadiosDisabled" disabled=""><span class="circle"></span><span class="check"></span> Disabled Radio is off
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadiosDisabled" checked="true" disabled=""><span class="circle"></span><span class="check"></span> Disabled Radio is on
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Input with success</label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty has-success">
                                        <label class="control-label"></label>
                                        <input type="text" class="form-control" value="Success">
                                        <span class="material-icons form-control-feedback">done</span>
                                        <span class="material-input"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Input with error</label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty has-error">
                                        <label class="control-label"></label>
                                        <input type="text" class="form-control" value="Error Input">
                                        <span class="material-icons form-control-feedback">clear</span>
                                        <span class="material-input"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Column sizing</label>
                                <div class="col-sm-10">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group label-floating is-empty">
                                                <label class="control-label"></label>
                                                <input type="text" class="form-control" placeholder=".col-md-3">
                                                <span class="material-input"></span></div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group label-floating is-empty">
                                                <label class="control-label"></label>
                                                <input type="text" class="form-control" placeholder=".col-md-4">
                                                <span class="material-input"></span></div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group label-floating is-empty">
                                                <label class="control-label"></label>
                                                <input type="text" class="form-control" placeholder=".col-md-5">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-header card-header-text" data-background-color="rose">
                            <h4 class="card-title">Form Elements</h4>
                        </div>
                        <div class="card-content">
                            <div class="row">
                                <label class="col-sm-2 label-on-left">With help</label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty ">
                                        <label class="control-label"></label>
                                        <input type="text" class="form-control" value="">
                                        <span class="material-icons form-control-feedback">done</span>
                                        <span class="material-input"></span></div>
                                    <div class="form-group label-floating is-empty has-error">
                                        <label class="control-label"></label>
                                        <input type="text" class="form-control" value="">
                                        <span class="material-icons form-control-feedback">clear</span>
                                        <span class="material-input"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Password</label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <input type="password" class="form-control" value="">
                                        <span class="material-input"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Placeholder</label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating">
                                        <label class="control-label"></label>
                                        <input type="text" class="form-control">
                                        <span class="material-input"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Disabled</label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <input type="text" placeholder="Disabled input here..." disabled="" class="form-control">
                                        <span class="material-input"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Static control</label>
                                <div class="col-sm-10">
                                    <div class="form-group">
                                        <p class="form-control-static">hello@creative-tim.com</p>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Checkboxes and radios</label>
                                <div class="col-sm-10 checkbox-radios">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes"><span class="checkbox-material"><span class="check"></span></span> First Checkbox
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes"><span class="checkbox-material"><span class="check"></span></span> Second Checkbox
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" checked="true"><span class="circle"></span><span class="check"></span> First Radio
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios"><span class="circle"></span><span class="check"></span> Second Radio
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Inline checkboxes</label>
                                <div class="col-sm-10">
                                    <div class="checkbox checkbox-inline">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes"><span class="checkbox-material"><span class="check"></span></span>a
                                        </label>
                                    </div>
                                    <div class="checkbox checkbox-inline">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes"><span class="checkbox-material"><span class="check"></span></span>b
                                        </label>
                                    </div>
                                    <div class="checkbox checkbox-inline">
                                        <label>
                                            <input type="checkbox" name="optionsCheckboxes"><span class="checkbox-material"><span class="check"></span></span>c
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile">File input</label>
                            <input type="file" id="exampleInputFile">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Check me out
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
            </div>
        </div>
    </div>
</div>