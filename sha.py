import hashlib

msg = "captain"

res = hashlib.sha512(msg.encode())

print("SHA 1 hash is : ", end="")
print(res.hexdigest())