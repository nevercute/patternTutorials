<jsp:useBean id="beatModel" scope="request" class="pro.nevercute.tut.patterns.complex.mvc.BeatModelImpl" />
<html>
<head>
    <title>DJView</title>
</head>
<body>
<h1>DJ View</h1>
<div>BPM per minutes: <jsp:getProperty name="beatModel" property="BPM"/></div>
<br>
<br>
<form method="post" action="/djview/servlet/DJView">
    BPM: <input type="text" name="bpm" value="<jsp:getProperty name="beatModel" property="BPM"/>">"
    <input type="submit" name="set" value="set"><br>
    <input type="submit" name="decrease" value="decrease"><br>
    <input type="submit" name="increase" value="increase"><br>
    <input type="submit" name="on" value="on"><br>
    <input type="submit" name="off" value="off"><br>
</form>
</body>
</html>
