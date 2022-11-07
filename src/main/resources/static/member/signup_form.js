
        window.onload = function(){
            //아이디에 admin 금지

            //Error
            var error = document.querySelectorAll('.error');
            console.log(error);

            var inputId = document.getElementById('id');
            var inputPw = document.getElementById('pw');
            var inputPw2 = document.getElementById('pw2');
            var inputName = document.getElementById('name');

            var inputBirth = document.getElementById('birth');
            var inputEmail = document.getElementById('email');
            var inputTell = document.getElementById('tell');


            inputId.addEventListener('focusout', checkId);
            inputPw.addEventListener('focusout', checkPw);
            inputPw2.addEventListener('focusout', checkPw2);
            inputEmail.addEventListener('focusout', checkEmail);
            inputTell.addEventListener('focusout', checkTell);          
            inputName.addEventListener('focusout', checkName);
            inputBirth.addEventListener('focusout', checkBirth);
            





            //아이디 양식 확인, 중복 확인 (e0)
            function checkId(){
                var idPattern = /^[a-zA-Z0-9_-]{5,20}$/;

                if(inputId.value == "") {
                    error[0].innerHTML = "아이디를 입력해주세요.";
                    error[0].style.display = "block";
                    error[0].style.color = "red";
                }else if(!idPattern.test(inputId.value)) {
                    error[0].innerHTML = "5-20자의 영문 대/소문자, 숫자, 특수문자(_),(-)를 사용하세요.";
                    error[0].style.display = "block";
                    error[0].style.color = "red";
                }else {
                	$.ajax({
	                    url: '/idduplcheck',
	                    data : { 
							inputId :  $('#id').val()
	                    }, 
	                    success: function(result){
							if(result == 'admin'){
								error[0].innerHTML = "'admin'이 들어간 아이디는 사용할 수 없습니다.";
								error[0].style.display = "block";
			                    error[0].style.color = "red";
							}else if(result =='impossible')	{	
								error[0].innerHTML = "이미 사용중이거나 탈퇴한 아이디입니다.";
			                    error[0].style.display = "block";
			                    error[0].style.color = "red";
							}else {	                       
								error[0].innerHTML = "사용 가능한 아이디입니다.";
			                    error[0].style.display = "block";
			                    error[0].style.color = "green";
							}
	                    },
				    	error:  function( xhr ) {
				    		 console.log( xhr );
				    		 //alert(xhr.status + ':' + xhr.statusText);
				    	}  
				    	
	                })

                }
            }

            
            //비밀번호 양식 확인 (e1)
            function checkPw(){
                var pwPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;
                
                if(pw.value == ""){
                    error[1].innerHTML = "비밀번호를 입력해주세요.";
                    error[1].style.display = "block";
                    error[1].style.color = "red";
                }else if(!pwPattern.test(inputPw.value)) {
                    error[1].innerHTML = "8-16자의 영문 대/소문자, 숫자, 특수문자를 사용하세요.";
                    error[1].style.display = "block";
                    error[1].style.color = "red";
                }else {
                    error[1].style.display = "none";
                }
            }
            

            //pw1, pw2 일치 여부 확인 (e2)
            function checkPw2(){
                if(pw2.value == pw.value && pw2.value != ""){
                    error[2].style.display = "none";
                }else if(pw2.value != pw.value) {
                    error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
                    error[2].style.display = "block";
                    error[2].style.color = "red";
                }else {
                    error[2].innerHTML = "비밀번호를 입력해주세요.";
                }
            }


            //이름 양식 확인 (e3)
            function checkName(){
                var namePattern = /^[a-zA-Z가-힣]*$/;
                if(inputName.value == ""){
                    error[3].innerHTML = "이름을 입력해주세요.";
                    error[3].style.display = "block";
                    error[3].style.color = "red";
                }else if(!namePattern.test(inputName.value) || inputName.value.indexOf(" ")>-1) {
                    error[3].innerHTML = "한글과 영문 대/소문자를 이용하세요. (숫자, 특수문자, 공백 사용 불가)";
                    error[3].style.display = "block";
                    error[3].style.color = "red";
                }else {
                    error[3].style.display = "none";
                }
            }

            //이메일 양식 확인 (e5)
            function checkEmail(){
                var emailPattern=/^[a-zA-Z0-9]([-_\.]?[0-9a-zA-Z]){2,}@[a-zA-Z]{2,}\.[a-zA-Z]{2,3}$/;
                if(inputEmail.value == "") {
                    error[5].innerHTML = "이메일을 입력해주세요.";
                    error[5].style.display = "block";
                    error[5].style.color = "red";
                }else if(!emailPattern.test(inputEmail.value)) {
                    error[5].innerHTML = "이메일 주소를 다시 확인해주세요.";
                    error[5].style.display = "block";
                    error[5].style.color = "red";
                }else {
                    error[5].style.display = "none";
                }
                
            } 
        
            //전화번호 양식 확인 (e6)
            function checkTell(){
                var tellPattern = /^01(0|1|9)([0-9]{3,4})([0-9]{4})$/;
                if(inputTell.value == ""){
                    error[6].innerHTML = "전화번호를 입력해주세요."
                    error[6].style.display = "block";
                    error[6].style.color = "red";
                }else if(!tellPattern.test(inputTell.value)){
                    error[6].innerHTML = "형식에 맞지 않는 전화번호입니다.";
                    error[6].style.display = "block";
                    error[6].style.color = "red";
                }else {
                    error[6].style.display = "none";
                }
            }


            
            //생년월일 양식 확인 (e4)
            function checkBirth() {
                var birthPattern = /^(19[0-9][0-9]|20\d{2})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/

                if(inputBirth.value == "") {
                    error[4].innerHTML = "생년월일을 입력해주세요.";
                    error[4].style.display = "block";
                    error[4].style.color = "red";
                }else if(!birthPattern.test(inputBirth.value)) {
                    error[4].innerHTML = "생년월일을 다시 확인해 주세요.";
                    error[4].style.display = "block";
                    error[4].style.color = "red";
                }else if(inputBirth.value > 20081103) {
                    error[4].innerHTML = "만 14세 이하의 어린이는 보호자의 동의가 필요합니다.";
                    error[4].style.display = "block";
                    error[4].style.color = "red";
                }
                else {
                    error[4].style.display = "none";
                }
            
            }



        }


