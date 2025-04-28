import hashlib


strTohash = "welcome"

result = hashlib.md5(strTohash.encode())


print("MD5 hash is : ", end="")
print(result.hexdigest())
s