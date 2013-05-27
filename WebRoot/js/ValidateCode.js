 var xmlHttp ;
	var flag = false ;
	function createXMLHttp(){
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest() ;
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") ;
		}
	}
	function checkUserid(securityCode){
		createXMLHttp() ;
		xmlHttp.open("POST","CheckSecurityCode.servlet?securityCode="+securityCode) ;
	
		xmlHttp.onreadystatechange = checkUseridCallback ;
		
		xmlHttp.send(null) ;
	}
	function checkUseridCallback(){
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){
				
				var text = xmlHttp.responseText ;
				if(text == "true"){	// �û�id�Ѿ�������
					//alert("ValidateCode false");
				changeAndClear();
					flag = false ;
				} else {
					//alert("ValidateCode true");
					flag = true ;
				}
			}
		}
	}
	function checkForm(){
		if(flag == false){
		//	alert(flag);
		alert("请输入正确的验证码");
		}
		return flag ;
	}
    function changeValidateCode(obj) {
           //��ȡ��ǰ��ʱ����Ϊ�����޾�������
        var timenow = new Date().getTime();
           //ÿ��������Ҫһ����ͬ�Ĳ��������ܻ᷵��ͬ�����֤��
        //���������Ļ�������й�ϵ��Ҳ���԰�ҳ������Ϊ�����棬����Ͳ�����������ˡ�
        obj.src="rand.action?d="+timenow;
    }
    function changeAndClear(){
    	
    	var v = document.getElementById("ValidateCodeImg");
		changeValidateCode(v);
		var cv = document.getElementById("cv");
		//alert("ssss");
		cv.value = "";
        }