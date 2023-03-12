--update barang set harga = 4000 where kode_barang = '005'
--delete from barang where kode_barang = '002'

--select * from barang

--drop table barang;

/*create table masyarakat (
	nik char (16) primary key,
	nama varchar (255) not null,
	username varchar (255) not null,
	password varchar (255) not null,
	telp varchar (13) not null
)*/

/*insert into masyarakat values ('1001', 'RIZKY SURYA MAULANA', 'rizky17', '123', '0895391203834')
insert into masyarakat values ('1002', 'DEVIN', 'devin001', '454', '089123123123')*/

/*create table pengaduan (
	id_pengaduan int primary key,
	tgl_pengaduan date,
	nik char (16),
	isi_laporan text,
	foto image,
	status varchar (10) not null check (status in('0', 'proses', 'selesai'))
)

select * from pengaduan*/

/*create table petugas (
	id_petugas int primary key,
	nama_petugas varchar (255) not null,
	username varchar (255) not null,
	password varchar (255) not null,
	telp varchar (13) not null,
	level varchar (10) not null check (level in('admin', 'petugas'))
)*/

/*insert into petugas (id_petugas, nama_petugas, username, password, telp, level) values (
	(101, 'YANI PUTRI', 'yanip', '123', '087551000121', 'petugas'),
	(102, 'SITI ALIAH', 'sitia', '100', '089443000123', 'admin')
)*/

--insert into petugas values (102, 'SITI ALIAH', 'sitia', '100', '089443000123', 'admin')

/*create table tanggapan (
	id_tanggapan int primary key,
	id_pengaduan int not null,
	tgl_tanggapan date not null,
	tanggapan text not null,
	id_petugas int not null
)*/

--insert into tanggapan values ('2', '10002', '2023-03-07', 'oke bro segera ditangani!', '102')

insert into pengaduan values ('10002', '2023-03-07', '1002', 'bang ini kok rusak ya???', 'foto2', 'proses')
select * from masyarakat
select * from pengaduan
select * from tanggapan