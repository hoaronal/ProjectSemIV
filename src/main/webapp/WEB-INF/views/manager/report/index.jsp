<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/quan-tri/quyen/xoa" var="deleteRoleAction"/>
<spring:url value="/quan-tri/quyen/cap-nhat" var="editRoleAction"/>
<script src="<c:url value="/resources/js/highcharts.js" />"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="purple">
                    <i class="material-icons">group</i>
                </div>
                <div class="card-content">
                    <a style="float: right" href="<%=request.getContextPath()%>/quan-tri/bao-cao"
                       class="btn btn-primary">Xuất file báo cáo</a>
                    <h4 class="card-title">Thống kê doanh số theo tháng</h4>
                    <div id="realTimeDataBarChart"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.onload = function() {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!

        var yyyy = today.getFullYear();
        if(dd<10){
            dd='0'+dd;
        }
        if(mm<10){
            mm='0'+mm;
        }
        var datetime = dd+'/'+mm+'/'+yyyy;
        var thang_1 = '${thang1}';
        var thang_2 = '${thang2}';
        var thang_3 = '${thang3}';
        var thang_4 = '${thang4}';
        var thang_5 = '${thang5}';
        var thang_6 = '${thang6}';
        var thang_7 = '${thang7}';
        var thang_8 = '${thang8}';
        var thang_9 = '${thang9}';
        var thang_10 = '${thang10}';
        var thang_11 = '${thang11}';
        var thang_12 = '${thang12}';
        var chart = new Highcharts.Chart({
            chart: {
                type: 'column',
                renderTo : 'realTimeDataBarChart',
            },
            title: {
                text : 'Thống kê doanh số hàng tháng ' + datetime,
                style: {

                }
            },
            xAxis: {
                categories: ['tháng 1', 'tháng 2', 'tháng 3', 'tháng 4', 'tháng 5',
                    'tháng 6', 'tháng 7', 'tháng 8', 'tháng 9', 'tháng 10', 'tháng 11', 'tháng 12'],
            },
            yAxis : {
                title : {
                    text : 'Đơn vị ',
                },
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                }
            },
            series: [{
                data: [parseInt(thang_1), parseInt(thang_2), parseInt(thang_3), parseInt(thang_4), parseInt(thang_5), parseInt(thang_6), parseInt(thang_7), parseInt(thang_8), parseInt(thang_9), parseInt(thang_10),parseInt(thang_11), parseInt(thang_12)],
                name: 'Doanh số hàng tháng'
            }]
        });
        document.getElementById("reportExamples").classList.add('in');
        document.getElementById("reportClass").classList.add('active');
    };
</script>