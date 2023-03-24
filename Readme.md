<p class="has-line-data" data-line-start="0" data-line-end="1">New Spring Boot project can be started from <a href="https://start.spring.io/">https://start.spring.io/</a></p>
<p class="has-line-data" data-line-start="2" data-line-end="3">Reference : <a href="https://www.youtube.com/playlist?list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q">https://www.youtube.com/playlist?list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q</a></p>
<p class="has-line-data" data-line-start="4" data-line-end="5">Refer this for connecting mySql DB with JPA : <a href="https://www.youtube.com/watch?v=D1dYsIyPTYM&amp;list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&amp;index=23">https://www.youtube.com/watch?v=D1dYsIyPTYM&amp;list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&amp;index=23</a></p>

**Setup Ngnix (Optional)**

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
