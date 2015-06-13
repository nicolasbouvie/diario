<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	var f = "${param.form}";
	$("#"+f+"Table tr").click(function() {
		var tr = $(this);
		$.each($("#"+f+"Form input[name^='"+f+".']"), function() {
			var field = $(this).attr("name").substr(f.length+1);
			$(this).val(tr.find("td[class='"+field+"']").html());
		});
		var reg = $(this).parent();
	});
</script>