<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="perfect-scrollbar-on">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><tiles:insertAttribute name="title"/></title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/material-dashboard.css" />"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/demo.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/css.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/web/css/bootstrap-datetimepicker.min.css" />"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/froala_editor.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/froala_style.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/plugins/code_view.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/plugins/image_manager.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/plugins/image.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/plugins/table.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/editor/css/plugins/video.css" />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">

    <script type="text/javascript">
        function checkNullOrEmpty(value) {
            return (!value || value == undefined || value == "" || value.length == 0);
        }
    </script>
</head>

<body>
<div class="wrapper">
    <tiles:insertAttribute name="sidebar"/>
    <div class="main-panel ps-container ps-theme-default ps-active-y">
        <tiles:insertAttribute name="nav"/>
        <div class="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/jquery-1.8.3.min.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>--%>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/material.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/perfect-scrollbar.jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/moment.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chartist.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.bootstrap-wizard.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-notify.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.sharrre.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datetimepicker.js" />"></script>
<%--<script type="text/javascript" src="<c:url value="/resources/js/nouislider.min.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/js/js.js" />"></script>--%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.select-bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.datatables.js" />"></script>
<%--<script type="text/javascript" src="<c:url value="/resources/js/sweetalert2.js" />"></script>--%>
<script type="text/javascript" src="<c:url value="/resources/js/jasny-bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/fullcalendar.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.tagsinput.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/material-dashboard.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/froala_editor.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/align.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/code_beautifier.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/code_view.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/draggable.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/image.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/image_manager.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/link.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/lists.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/paragraph_format.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/paragraph_style.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/table.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/video.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/url.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/editor/js/plugins/entities.min.js" />"></script>

<script type="text/javascript">
    $(function(){
        $('#edit').on('froalaEditor.initialized', function (e, editor) {
                /*$('#edit').parents('form').on('submit', function () {
                    /!*console.log($('#edit').val());*!/
                    return true;
                })*/
            })
            .froalaEditor({enter: $.FroalaEditor.ENTER_P, placeholderText: null})
    });

    $('#btnSearch').click(function () {
        $('#clickSearch').val('true');
        $('.formSearch').submit();
    });

    $(document).ready(function () {
        var checkAction = '${msg}';
        var style = '${style}';
        if (checkAction.length > 0) {
            if (style == 'info') {
                showMsgInfo('top', 'center', checkAction);
            } else {
                showMsgError('top', 'center', checkAction);
            }
        }

        demo.initFormExtendedDatetimepickers();

        var clickSearch = $('#clickSearch').val();
        if (clickSearch == 'true') {
            var contentSearch = "";
            $('table').each(function (ind) {
                $(this).find('tr').each(function () {
                    $(this).find('td').each(function (i) {
                        var contentSearch = $(this).text();
                        var keySearch = '<c:out value="${keySearch}"/>';
                        if ($(this).text().indexOf(keySearch) > -1) {
                            var result = contentSearch.replace(keySearch, '<span style="background: orange;">' + keySearch + '</span>');
                            $(this).html(result);
                        }
                    });
                });
            });
        }

        $('#datatables').DataTable({
            "bLengthChange": false,
            "bInfo": false,
            "bFilter": false,
            "bPaginate": false,
            "bAutoWidth": false,
            "sPaginationType": "full_numbers",
            responsive: true,
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search records",
            }
        });
    });

    function showMsgInfo(froms, align, a) {
        type = ['info'];
        color = Math.floor((Math.random() * 6) + 1);
        $.notify({
            icon: "notifications",
            message: a
        }, {
            type: type[0],
            timer: 3000,
            placement: {
                from: froms,
                align: align
            }
        });
    }

    function showMsgError(froms, align, a) {
        type = ['danger'];
        $.notify({
            icon: "notifications",
            message: a
        }, {
            type: type[0],
            timer: 3000,
            placement: {
                from: froms,
                align: align
            }
        });
    }

    /*function readURL(input) {

        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $('#blah').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgInp").change(function() {
        readURL(this);
    });*/
</script>
</body>
</html>