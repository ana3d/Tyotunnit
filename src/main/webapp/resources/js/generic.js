
$(document).ready(function() {
	$("#work_date").datepicker({dateFormat : "yy-mm-dd"	});
	$('#work_date').datepicker('setDate', '+0');
	$("#start_time").timepicker();
	$("#end_time").timepicker();
});
