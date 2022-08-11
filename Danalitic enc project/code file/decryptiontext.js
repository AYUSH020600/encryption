function fun2()
{
    console.log(document.getElementById("text2").value,document.getElementById("pass2").value);
    var decrypted =CryptoJS.AES.decrypt(document.getElementById("text2").value,document.getElementById("pass2").value).toString(CryptoJS.enc.Utf8);
    console.log(decrypted);
    document.getElementById("result2").innerHTML=decrypted;
}