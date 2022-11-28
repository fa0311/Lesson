import socket
import glob
import cv2
import time
import numpy as np

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(("0.0.0.0", 49152))
s.listen(5)

files = glob.glob("assets/badapple/*.jpg")

while True:
    print("Waiting...")
    clientsocket, address = s.accept()
    print("Connected: " + str(address))
    try:
        for file in files:
            img = cv2.imread(file)
            height = img.shape[0]
            width = img.shape[1]
            output = ""
            for y in range(0, height, 8):
                for x in range(0, width, 8):
                    imgBox = img[y, x]
                    if np.all(imgBox == np.array([255,255,255])):
                        output += ":"
                    else:
                        output += " "
                output += "\n"

            clientsocket.send(output.encode())
            time.sleep(1/20)
    except:
        pass
    clientsocket.close()