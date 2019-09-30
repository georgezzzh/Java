import requests
import re
from urllib import parse
def stringToHex(string):
    length = len(string)
    hex_string = str()
    for i in range(length):
        hex_string += hex(ord(string[i]))[2:]
    return hex_string
def get_cookie(url):
    hex_string = stringToHex(url)
    cookie = {"srcurl": hex_string, "path": "/"}
    return cookie
#url = "http://www.hnrexian.com/archives/category/jk"
url="https://e.glgoo.top/scholar?cites=12452666453585360586&start=0"
s = requests.Session()
r = s.get(url)
#print("session is:",s.cookies.values())
#print("r.text()",r.text) 
url_2 = re.compile("self\.location\s*=\s*\"(.*?)\"").findall(r.text)[0]
screen_date = "1920,1080"
print("\n\nmatch url2 is:", url_2)
url_2 = url_2 + stringToHex(screen_date)

url_2 = parse.urljoin(url, url_2)
print("url2:", url_2)
cookie = get_cookie(url)
print("url2's cookie:",cookie)
s.cookies.update(cookie)
r2 = s.get(url_2)
print("url3's  cookies:\t",s.cookies)
url3 = re.compile("self\.location\s*=\s*\"(.*?)\"").findall(r2.text)[0]
print("url3:",url3)
#print("url3' cookies:\t",s.cookies)
r3 = s.get(url3)
#print("r3 text is:\t!!!!!!",r3.text)
r3.encoding = "utf8"
f=open('index.html','w')
f.write(r3.text)
f.close()
#print(r3.text)