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
<p>�����ȣ : <input type="text" name="p_empno" value="${eb.employee_id }" readonly="readonly"></p><br>
<p>��� �̸� : <input type="text" name="p_fname" value="${eb.first_name }"></p><br>
<p>��� �� : <input type="text" name="p_lname" value="${eb.last_name }"></p><br>
<p>E-mail : <input type="text" name="p_mail" value="${eb.email}"></p><br>
<p>��ȭ��ȣ : <input type="text" name="p_pnum" value="${eb.phone_number }"></p><br>
<p>�Ի��� : <input type="text" name="p_date" value="${eb.hire_date }"></p><br>
<p>Job ID : <input type="text" name="p_jobid" value="${eb.job_id }"></p><br>
<p>�޿� : <input type="text" name="p_salary" value="${eb.salary }"></p><br>
<p>��% : <input type="text" name="p_compct" value="${eb.commission_pct }"></p><br>
<p>�Ŵ��� ID : <input type="text" name="p_mgr" value="${eb.manager_id}"></p><br>
<p><input type="button" value="����" onclick="mod_ok()">
   <input type="hidden" value="emp_update" name="p_code">
</p><br>


</form>

</body>
</html>