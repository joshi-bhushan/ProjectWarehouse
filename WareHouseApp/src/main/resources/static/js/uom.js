$(document).ready(function(){

	// 1. hide error section
	$("#uomTypeError").hide();
	$("#uomModelError").hide();
	$("#uomDescError").hide();
	
	
	//2.define error variable
	var uomTypeError = false;
	var uomModelError = false;
	var uomDescError = false;
	
	//3. validate function
	
	function validate_uomType(){
		
		var val=$("uomType").val();
		if(val == '')
			{
			$("#uomTypeError").show();
			$("#uomTypeError").html("plz choose one <b> Uom type</b>");
			$("#uomTypeError").css('color','red');
			
			}
		else
			{
			$("#uomTypeError").hide();
			uomTypeError = true;
			}
		return uomTypeError;
	}
	
	function validate_uomModel(){
		
		var val =$("#uomModel").val();
		var exp =/^[A-Z0-9\.\-]{4,12}$/;
		if(val=='')
			{
			$("#uomModelError").show();
			$("#uomModelError").html("Enter<b>Uom model</b>");
			$("#uomModelError").css('color','red');
			uomModelError = false;
			
			
			}
		else if(!exp.test(val)){
			$("#uomModelError").show();
			$("#uomModelError").html("Invalid<b>Uom model</b>");
			$("#uomModelError").css('color','red');
			uomModelError = false;
			
		}
		else
			{
			$("#uomModelError").hide();
			  = true
			
			}
		return uomModelError;
	}
	
	 function validate_uomDesc(){
         var val = $("#uomDesc").val();
         var exp =/^[A-Za-z0-9\.\,\s\-]{5,150}$/;
         if(val=='') {
             $("#uomDescError").show();
             $("#uomDescError").html("Description <b> can not be empty</b>");
             $("#uomDescError").css('color','red');
             uomDescError = false;
         } else if(!exp.test(val)) {
             $("#uomDescError").show();
             $("#uomDescError").html("Description <b> must bte 5-150 chars only</b>");
             $("#uomDescError").css('color','red');
             uomDescError = false;
         } else {
             $("#uomDescError").hide();
             uomDescError = true;
         }
         return uomDescError;
     }
	
	 // 4. link with action even
	 $("#uomType").change(function(){
		 
		validate_uomType();
	 })
	 
	 $("uomModel").keyup(function(){
		
		 $(this).val($(this).val().toUpperCase());
		 validate_uomModel();
		 
	 })
	  $("#uomDesc").keyup(function(){
                validate_uomDesc();
            })
            
            //5. on form submit
            $("#uomRegForm").submit(function(){
            	validate_uomModel();
            	validate_uomType();
            	validate_uomDesc();
            	
            	if(uomModelError && uomTypeError && uomDescError)
            	return true;          // means submit
            	else
            		return false;      //  means not sumbit
            });
            
            
	 
});




