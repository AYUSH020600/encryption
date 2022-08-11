function fun1()
{
    console.log(document.getElementById("text1").value,document.getElementById("pass").value);
    var encrypted =CryptoJS.AES.encrypt(document.getElementById("text1").value,document.getElementById("pass").value);
    console.log(encrypted);
    document.getElementById("result").innerHTML=encrypted;
}
function fun2()
{
    var str=document.getElementById("text2").nodeValue;
    alert("the decrypted value is");
}