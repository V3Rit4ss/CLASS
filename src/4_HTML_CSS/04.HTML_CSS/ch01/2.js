// JavaScript source code
/*여러줄 주석  // 한줄주석. */
//동적인 부분.
name = prompt("이름이 뭐니?", "홍길동");
document.write(name + "~Welcome<br>");
function chk() { /* chk 변수선언*/
    if (frm.tel.value.length < 4) {
        alert("전화번호는 뒷 4자리 이상 입력해야합니다.");
        return false;
    }
}