"use strict"
const adminVue = {
		join : () =>{
			return `<table id="kcdc">
	        <tr>
            <td id="contents" colspan="4">
                <table id="admin" style="width: 80%; height:80%; margin: 0 auto">
                <tr style="width: 80%;height: 50px;">
                  <td rowspan="4">
                    <img src="/resources/img/bab.jpg">
                  </td>
                  <td style="height: 20%">
                    <label>이름</label>
                  </td>
                  <td>
                    <input id="name" type="text" />
                  </td>
                </tr>  
                <tr style="height: 20%">
                  <td >
                    <label>직급</label>
                  </td>
                  <td>
                    <input id="position" type="text" />
                  </td>
                </tr>
                <tr style="height: 20%">
                  <td>
                    <label>이메일</label>
                  </td>
                  <td>
                    <input id="email" type="text" />
                  </td>
                </tr>
                <tr style="height: 20%">
                  <td>
                    <label>전화번호</label>
                  </td>
                  <td>
                    <input id="phoneNumber" type="text" />
                  </td>
                </tr>
                <tr style="height: 20%">
                  <td colspan="3" id="button_box">
                    
                  </td>
                </tr>
              </table>
            </td>
        </tr>
    </table>`
		},
		login : () =>{
			return `
			<article>
				<form id="login_box">
				<label>ID </label><br>
				<input id=userid type="text"><br>
				<label>PASSWORD </label><br>
				<input id=password type="text"><br><br>
				</form>
			</article>`
		},
		adminAll : () =>{
			return `
			<table id="adminData">
                        <tr>
                            <td>
                                <a id="number">No.</a>
                            </td>
                            <td>
                                <a id="employNumber">사번</a>
                            </td>
                             <td>
                                <a id="name">이름</a>
                            </td>
                           <td>
                                <a id="position">직급</a>
                            </td>
                            <td>
                                <a id="email">이메일</a>
                            </td>
                            <td>
                                <a id="phoneNumber">전화번호</a>
                            </td>
                            <td>
                                <a id="registerDate">등록일자</a>
                            </td>
                        </tr>
                    </table>`
		}
}