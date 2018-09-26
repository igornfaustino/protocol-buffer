from musica_pb2.py import Music
from datetime import datetime
import socket

HOST = ''              # Endereco IP do Servidor
PORT = 5553            # Porta que o Servidor esta
server_tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
orig = (HOST, PORT)
server_tcp.bind(orig)
server_tcp.listen(1)
while True:
    con, cliente = server_tcp.accept()
    print 'Concetado por', cliente
    try:
        music_list = Music() 
        while True:
            msg = con.recv(1024)
            if not msg: break
            music_list.ParseFromString(msg)
            for music in music_list:
                print('Nome da música: ', music.nome)
                print('Nome do álbum: ', music.album)
                print('Número da faixa: ', music.trackNro)
                print('Está nas rádios? ', music.onTheRadio)

            print cliente, msg   
    except KeyboardInterrupt as ex:
        print 'Finalizando conexao do cliente', cliente
        con.close()