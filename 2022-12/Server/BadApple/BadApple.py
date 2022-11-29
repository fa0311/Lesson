import socket
import glob
import cv2
import time
import numpy as np
import asyncio
import random

def play(clientsocket):
    try:
        for file in random.choice(files):
            img = cv2.imread(file)
            height = img.shape[0]
            width = img.shape[1]
            output = ""
            for y in range(0, height, scale * 2):
                output += "\n"
            for y in range(0, height, scale * 2):
                for x in range(0, width, scale):
                    imgBox = img[y, x]
                    if height > y + scale:
                        upImgBox = img[y + scale, x]
                    else:
                        upImgBox = imgBox

                    if np.all(imgBox > np.array(color)) and np.all(upImgBox > np.array(color)):
                        output += ":"
                    elif np.all(imgBox > np.array(color)):
                        output += "'"
                    elif np.all(upImgBox > np.array(color)):
                        output += "."
                    else:
                        output += " "
                output += "\n"

            clientsocket.send(output.encode())
            time.sleep(1/20)
    except Exception as e:
        print(e)
    clientsocket.close()


s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(("0.0.0.0", 49152))
s.listen(5)

files = [glob.glob("assets/nyancat/*.jpg"), glob.glob("assets/badapple/*.jpg")]

scale = 8
color = [100,100,100]

while True:
    clientsocket, address = s.accept()
    print("Connected: " + str(address))
    clientsocket.send("Loading now...".encode())
    asyncio.new_event_loop().run_in_executor(None, play, clientsocket)