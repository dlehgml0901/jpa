"use strict"

var admin = admin || {}
admin = (()=>{
	const WHEN_ERROR = `호출하는 JS 파일을 찾지 못했습니다.`
	let user_vue
	let init = () => {
		user_vue = '/resources/vue/user_vue.js'
		onCreate()
	}
	let onCreate = () => {
		$.when(
			$.getScript(user_vue)	
		).done(()=>{
			setContentView()
			$.getJSON('/users', d=>{
				$('#total_count').text('총 회원수 :' + d.length + '명')
				$.each(d, (i, j) =>{
					$(`<tr>
	                    	<td>
	                            <span>${i+1}</span>
	                        </td>
	                        <td>
	                            <span>${j.userid}</span>
	                        </td>
	                        <td>
	                            <span id="user_`+(i+1)+`"></span>
	                        </td>
	                         <td>
	                            <span>${j.ssn}</span>
	                        </td>
	                       <td>
	                            <span>${j.email}</span>
	                        </td>
	                        <td>
	                            <span>${j.phoneNumber}</span>
	                        </td>
	                        <td>
	                            <span>${j.registerDate}</span>
	                        </td>
	                        
	                    </tr>`).appendTo('#userData')
	                    $(`<a>${j.name}</a>`)
	                    .css({cursor: 'pointer', color:'blue'})
	                    .appendTo("#user_"+(i+1))
	                    .click(e=>{
	                    	e.preventDefault()
	                    	$('#userData').empty()
	                    	$(userVue.detail())
	                    	.appendTo('#userData')
	                    	$.getJSON(`/users/${j.userid}`, d => {
	                    			$('#userid').text(d.userid)
	                    			$('#userName').text(d.name)
	                    			$('#userSSN').text(d.ssn)
	                    			$('#userAddr').text(d.addr)
	                    			$('#userEmail').text(d.email)
	                    			$('#userPhoneNumber').text(d.phoneNumber)
	                    			$('#registerDate').text(d.registerDate)
	                    		})
	                    	})
	                    })
	        })
	        $('#user_list').click( e=>{
				e.preventDefault()
				location.href = "/admin"
			})
			$('#item_list').click( e=>{
				e.preventDefault()
				$('#content').empty()
				$('#content').html(`<table id="items">
                        <tr>
                            <th>
                                <span>No.</span>
                            </th>
                            <th>
                                <span>분실물 ID</span>
                            </th>
                            <th>
                                <span>습득 물품명</span>
                            </th>
                            <th>
                                <span>습득 일자</span>
                            </th>
                            <th>
                                <span>습득물 분류</span>
                            </th>
                            <th>
                                <span>습득 위치(지하철)</span>
                            </th>
                        </tr>
                    </table>`)
                    $.getJSON(`/items`, d=>{
                    	$('#total_count').text('총 분실물 건수 : ' + d.length + '건')
                    	$.each(d, (i,j)=>{
                    		$(`<tr>
								<td>
								<span>${i+1}</span>
								</td>
								<td>
								<span>${j.itemId}</span>
								</td>
								<td>
								<span>${j.itemName}</span>
								</td>
								<td>
								<span>${j.takerDate}</span>
								</td>
								<td>
								<span>${j.category}</span>
								</td>
								<td>
								<span>${j.takenPostion}</span>
								</td>
						</tr>`).appendTo('#items')
                    	})
                    })
			})
			$('#admin_list').click( e=>{
				e.preventDefault()
				$('#content').empty()
				$('#content').html(`<table id="admins">
                        <tr>
                            <th>
                                <a>No.</a>
                            </th>
                          <th>
                                <a>사번</a>
                            </th>
                           <th>
                                <a>이름</a>
                            </th>
                         <th>
                                <a>직급</a>
                            </th>
                          <th>
                                <a>이메일</a>
                            </th>
                          <th>
                                <a>전화번호</a>
                            </th>
                          <th>
                                <a>등록일자</a>
                            </th>
                        </tr>
                    </table>`)
                    $.getJSON(`/admins`, d=>{
                    	$('#total_count').text('총 사원 수 : ' + d.length + '명')
					$.each(d, (i, j) =>{
						$(`<tr>
								<td>
								<span>${i+1}</span>
								</td>
								<td>
								<span>${j.employNumber}</span>
								</td>
								<td>
								<span>${j.name}</span>
								</td>
								<td>
								<span>${j.position}</span>
								</td>
								<td>
								<span>${j.email}</span>
								</td>
								<td>
								<span>${j.phoneNumber}</span>
								</td>
								<td>
								<span>${j.registerDate}</span>
								</td>
						</tr>`).appendTo('#admins')
					})
				})
			})
		}).fail(()=>{
			alert(WHEN_ERROR)
		})
	}		
	let setContentView = () =>{
		$('#userData tr').first().css({'background-color':'yellow'})
		$('#items tr').first().css({'background-color':'yellow'})
		$('#admins tr').first().css({'background-color':'yellow'})
	}
	return {init}
})()