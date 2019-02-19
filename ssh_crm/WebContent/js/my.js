	function loadSelect(typecode, postionId, selectname, selectId) {
		var $select = $("<select name="+selectname+"><select/>");
		$select.append($("<option value=''>---请选择---</option>"));
		$.post("$(pageContext.request.contextPath)/BaseDictAction",
			{dict_type_code : typecode}, 
			function(data) {
				$.each(data, function(i, json) {
				var $option = $("<option value='"+json['dict_id']+"'>"+ json['dict_item_name'] + "</option>");
				if (json["dict_id"] == selectId) {
					$option.attr({selected : "selected"});};
				$select.append($option);
				});}, 
			"json");
		$("#" + postionId).append($select);
	};
	