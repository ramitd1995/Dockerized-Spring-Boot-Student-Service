<p class="has-line-data" data-line-start="0" data-line-end="1">New Spring Boot project can be started from <a href="https://start.spring.io/">https://start.spring.io/</a></p>
<p class="has-line-data" data-line-start="2" data-line-end="3">Reference : <a href="https://www.youtube.com/playlist?list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q">https://www.youtube.com/playlist?list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q</a></p>

___

**Setup Nginx (Optional)**

<p class="has-line-data" data-line-start="0" data-line-end="3">Install nginx in mac : brew install nginx<br>
Run : nginx<br>
Default nginx port is 8080</p>
<p class="has-line-data" data-line-start="4" data-line-end="5">Locate nginx.conf file for nginx configuration with : nginx -t</p>
<p class="has-line-data" data-line-start="6" data-line-end="8">Open nginx.conf file and clear the file.<br>
Update the file with below :</p>
<pre><code class="has-line-data" data-line-start="9" data-line-end="29">http {

    include mime.types;

    upstream backendserver {
        server 127.0.0.1:8090;
    }

    server {
        listen 8080;
        root /Users/ramitdhamija/IdeaProjects/buildservice;

        location / {
            proxy_pass http://backendserver/;
        }
    }
}

events {}
</code></pre>
<p class="has-line-data" data-line-start="30" data-line-end="32">Reload nginx server with :  nginx -s reload<br>
Validate all api’s can be accessed on nginx server with port 8080</p>
<p class="has-line-data" data-line-start="33" data-line-end="34">To setup nginx api gateway for multiple micro services, refer : <a href="https://www.youtube.com/watch?v=-IBZGS_UXhU">https://www.youtube.com/watch?v=-IBZGS_UXhU</a></p>

___
**Postgres Integration**

<p class="has-line-data" data-line-start="0" data-line-end="1">Integration of postgres with springboot framework using JdbcTemplate : <a href="https://www.youtube.com/watch?v=p_xrBVxOmq8">https://www.youtube.com/watch?v=p_xrBVxOmq8</a></p>
<p class="has-line-data" data-line-start="2" data-line-end="3">Quick steps to be performed for postgres setup :</p>
<ol>
<li class="has-line-data" data-line-start="3" data-line-end="4">Download postgres for DB integration : <a href="https://www.postgresql.org/download/">https://www.postgresql.org/download/</a></li>
<li class="has-line-data" data-line-start="4" data-line-end="5">Once downloaded, configure pgadmin in local and create a database.</li>
<li class="has-line-data" data-line-start="5" data-line-end="7">Add postgres configuration in application.properties(db name, username, password). Default username is postgres and default postgres port is 5432.</li>
</ol>
<p class="has-line-data" data-line-start="7" data-line-end="8">DB table “student_data” would get automatically created once spring boot application is launched.</p>
