<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function mod_ok(){
		document.modForm.submit();		
	}
</script>
<title>Modify Employee</title>
</head>
<body>
<form action="Emp.do" method="post" name="modForm">
<p>사원번호 : <input type="text" name="p_empno" value="${eb.employee_id }" readonly="readonly"></p><br>
<p>사원 이름 : <input type="text" name="p_fname" value="${eb.first_name }"></p><br>
<p>사원 성 : <input type="text" name="p_lname" value="${eb.last_name }"></p><br>
<p>E-mail : <input type="text" name="p_mail" value="${eb.email}"></p><br>
<p>전화번호 : <input type="text" name="p_pnum" value="${eb.phone_number }"></p><br>
<p>입사일 : <input type="text" name="p_date" value="${eb.hire_date }"></p><br>
<p>Job ID : <input type="text" name="p_jobid" value="${eb.job_id }"></p><br>
<p>급여 : <input type="text" name="p_salary" value="${eb.salary }"></p><br>
<p>상여% : <input type="text" name="p_compct" value="${eb.commission_pct }"></p><br>
<p>매니저 ID : <input type="text" name="p_mgr" value="${eb.manager_id}"></p><br>
<p><input type="button" value="수정" onclick="mod_ok()">
   <input type="hidden" value="emp_update" name="p_code">
</p><br>


</form>

</body>
</html>