from musica_pb2 import Music
from datetime import datetime
import socket

HOST = ''              # Endereco IP do Servidor
PORT = 5555            # Porta que o Servidor esta
server_tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
orig = (HOST, PORT)
server_tcp.bind(orig)
server_tcp.listen(1)
while True:
    con, cliente = server_tcp.accept()
    print('Concetado por', cliente)
    try:
        music = Music()
        size = int.from_bytes(con.recv(4), 'big')
        msg = con.recv(size)

        if not msg:
            break
        music.ParseFromString(msg)
        print('Nome da musica: ', music.nome)
        print('Nome do album: ', music.album)
        print('Numero da faixa: ', music.trackNro)
        print('Esta nas radios? ', music.onTheRadio)
        print('\n-------------------\n')

    except KeyboardInterrupt as ex:
        print('Finalizando conexao do cliente', cliente)
        con.close()
