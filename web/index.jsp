<script>
    function findmed(str)
    {
            var xmlhttp;
            if (str.length==0)
            { 
                document.getElementById("s1").innerHTML="";
                return;
            }
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementById("s1").innerHTML=xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET","Fetchmed.jsp?q="+str,true);
            xmlhttp.send();
    }
</script>

<h1>Welcome to File Tracker Systematic</h1>

<p>File tracking Name <input onkeyup="findfile(this.value)" type="text" name="T1" /></p>
 <span id="s1"></span>