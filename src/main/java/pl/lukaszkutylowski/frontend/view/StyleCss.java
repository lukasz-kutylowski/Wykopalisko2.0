package pl.lukaszkutylowski.frontend.view;

public class StyleCss {

    public static String getStyleCss() {
        StringBuilder s = new StringBuilder();

        s.append("    <style>");

        s.append("body {");
        s.append("	background-color: #efefef;");
        s.append("}");

        s.append(".container {");
        s.append("	width: 100%;");
        s.append("	margin-left: auto;");
        s.append("	margin-right: auto;");
        s.append("}");

        s.append(".navbar-brand {");
        s.append("	background-color: #0099ff;");
        s.append("	width: 99%;");
        s.append("	padding: 5px;");
        s.append("}");

        s.append(".brand {");
        s.append("	color: white;");
        s.append("	font-size: 40px;");
        s.append("	font-weight: bold;");
        s.append("	width: 240px;");
        s.append("	align: left;");
        s.append("}");

        s.append(".menu {");
        s.append("	width: 100%;");
        s.append("	align: center;");
        s.append("}");

        s.append(".navbar-button {");
        s.append("	background-color: #0099ff;");
        s.append("	width: 33.3%;");
        s.append("	height: 25px;");
        s.append("	font-size: 18px;");
        s.append("	padding: 5px 0 5px 0;");
        s.append("	float: left;");
        s.append("	text-align: center;");
        s.append("}");

        s.append(".navbar-button:hover {");
        s.append("	background-color: #000000;");
        s.append("	cursor: pointer;");
        s.append("}");

        s.append("a:link {");
        s.append("	color: white;");
        s.append("	text-decoration: none;");
        s.append("	text-align: center;");
        s.append("}");

        s.append("a:visited {");
        s.append("	color: white;");
        s.append("}");

        s.append("a:hover {");
        s.append("	color: FFFFFF;");
        s.append("}");

        s.append(".end {");
        s.append("	clear: both;");
        s.append("}");

        s.append(".space {");
        s.append("	background-color: #efefef;");
        s.append("	width: 100%;");
        s.append("	height: 20px;");
        s.append("}");

        s.append(".up-vote {");
        s.append("	width: 50%;");
        s.append("	height: 24px;");
        s.append("	color: green;");
        s.append("	text-align: center;");
        s.append("	font-size: 15px;");
        s.append("	float: left;");
        s.append("	background-color: white;");
        s.append("}");

        s.append(".up-vote:hover {");
        s.append("	background-color: gray;");
        s.append("}");

        s.append(".down-vote {");
        s.append("	width: 50%;");
        s.append("	height: 24px;");
        s.append("	color: red;");
        s.append("	text-align: center;");
        s.append("	font-size: 15px;");
        s.append("	float: left;");
        s.append("	background-color: white;");
        s.append("}");

        s.append(".down-vote:hover {");
        s.append("	background-color: gray;");
        s.append("}");

        s.append(".title {");
        s.append("	width: 100%;");
        s.append("	font-size: 18px;");
        s.append("	background-color: lightgray;");
        s.append("	color: #0099ff;");
        s.append("	text-align: center;");
        s.append("	font-weight: bold;");
        s.append("}");

        s.append(".description {");
        s.append("	width: 100%;");
        s.append("	font-size: 18px;");
        s.append("	background-color: lightgray;");
        s.append("	text-align: center;");
        s.append("	color: black;");
        s.append("}");

        s.append(".link {");
        s.append("	width: 100%;");
        s.append("	font-size: 18px;");
        s.append("	background-color: lightgray;");
        s.append("	text-align: center;");
        s.append("	font-weight: bold;");
        s.append("	padding: 5px;");
        s.append("	color: black;");
        s.append("}");

        s.append(".link:hover {");
        s.append("	width: 100%;");
        s.append("	font-size: 18px;");
        s.append("	background-color: gray;");
        s.append("	text-align: center;");
        s.append("	font-weight: bold;");
        s.append("	padding: 5px;");
        s.append("	color: black;");
        s.append("}");

        s.append(".form-control {");
        s.append("	height: 25px;");
        s.append("	width: 200px;");
        s.append("	padding: 10px;");
        s.append("}");

        s.append(".apply-button {");
        s.append("	height: 31px;");
        s.append("}");

        s.append(".link-register {");
        s.append("	color: red;");
        s.append("	font-size: 25px;");
        s.append("}");

        s.append(".login-info {");
        s.append("	color: black;");
        s.append("	padding: 10px;");
        s.append("	width: 240px;");
        s.append("	text-align: center;");
        s.append("}");

        s.append(".footer {");
        s.append("	background-color: #0099ff;");
        s.append("	color: white;");
        s.append("	width: 100%;");
        s.append("	height: 25px;");
        s.append("	text-align: center;");
        s.append("	font-size: 20px;");
        s.append("}");

        s.append(".delete {");
        s.append("	width: 100%;");
        s.append("	height: 24px;");
        s.append("	color: red;");
        s.append("	text-align: center;");
        s.append("	font-size: 15px;");
        s.append("	float: left;");
        s.append("	background-color: white;");
        s.append("}");

        s.append("</style>");

        return s.toString();
    }
}
