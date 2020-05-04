"use strict"

var admin = admin || {}
admin = (()=>{
	let init = () => {
		onCreate()
	}
	let onCreate = () => {
		setContentView()
		$('#user_all').click( e=>{
		$.getJSON('/users', d=>{
			$('#total_count').text('총 회원수 :' + d.length)
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
                    	alert(`${j.userid}`)
                    })
			})
		})
		})
		$('#admin_all').click( e=>{
			e.preventDefault()
			$('#content').empty()
			$('#content').html(adminVue.adminAll())
			
			$.getJSON('/admins', d=>{
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
                        
                    </tr>`).appendTo('#adminData')
			})
		})
		})
	}
	let setContentView = () =>{
		$('#userData tr').first().css({'background-color':'yellow'})
		$('#adminData tr').first().css({'background-color':'yellow'})
	}
	return {init}
})()