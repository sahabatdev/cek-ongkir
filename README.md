# cek-ongkir

Login APK
Username : maulana
Password : maulana

1. Apakah anda pernah menggunakan Kotlin? Jika pernah jelaskan perbedaan mendasar
antara Kotlin dengan Java sesuai dengan pengalaman anda.

Jawaban : Pernah menggunakan mengikuti Beasiswa Kotlin Android Developer Dicoding namun tidak sampai tuntas. Perbedaan yang terlihat menurut saya ialah exception di kotlin lebih bagus karena misalkan ada variabel yang belum di diinisialisasi akan di cek pada compiler, menghubungkan antara resource xml pun tidak perlu findViewById, bisa langsung memanggil id nya.., bisa membuat tampilan di java dengan struktur yang mudah sehingga meringakan size, dan banyak kelebihan lainnya.

2. Apa saja library Android yang sering atau biasa anda pakai? Jelaskan kegunaannya
bagi anda.

Intuit SDP -> Supaya ukuran size responsive terhadap semua layar android
Retrofit -> Untuk melakukan Parsing API
Gson -> untuk konversi string json ke model ataupun sebaliknya
Support Design -> Untuk material desain supaya menarik

3. Apakah anda menggunakan prinsip clean code atau design pattern untuk project
Android anda? Jelaskan penerapan clean code atau design pattern yang biasa anda
gunakan dan manfaatnya untuk anda.

Saya merasa sudah cukup menggunakan sebagian kriteria clean code, yaitu menghindari duplicate code dengan membuat base activity, lalu setiap method di usahakan hanya memiliki satu fungsi sehingga harus di buat kan method lain. Dengan menerapkan clean code ini akan meningkatkan performa dari si aplikasi dalam menjalankan proses dan memudahakan dalam membaca kembali kode.

Untuk Design pattern yang saya gunakan menggunakan pattern Model View Presenter, saya memilih ini karena pattern yang sering digunakan mengembangan android karena cocok dengan tipikal android, Memudahkan dalam estafet kode nantinya pada orang lain karena strukur yang jelas dan rapi serta memudahkan dalam automated testing karena menggunakan interface.

4. Apakah tantangan terbesar yang pernah anda temui dalam mengerjakan project
Android dan bagaimana anda menyelesaikannya dari sisi engineering?

Tampilan yang kurang reseponsive untuk semua layar, harus mengikuti perkembangan android misal permission dll, perrbedaan tipe hp membuat kadang terjadi error apalagi untuk hp dengan ram yang rendah.

5. Untuk efisiensi pengerjaan project dalam tim, bagaimana workflow anda dari proses
development hingga merilis aplikasi hingga bisa digunakan oleh tester / client?

Workflow saya biasa menggunakan scrum agile, jadi dimana ada PO sebagai yang memahami requirements, lalu ada development team yang bekerja bersama setiap ada perubahan atau perkembangan, lalu melakukan sprint review dari hasil selama 1 sprint, dan di akhiri dengan sprint retrospective untuk mengevaluasi pekerjaan yang kita sudah lakukan.

6. Jelaskan teknik-teknik apa saja yang dapat meningkatkan performance dan keamanan
sebuah aplikasi Android.

Mulai dari Asyncrounous, tidak menulis statis data yang cukup privat, Thread, lalu untuk meringankan size di anjurkan menggunakan gambar svg atau webp.

7. Apakah anda bersedia onsite di Malang?
Bersedia

Terimakasih atas perhatiannya.

Developed by Maulana Rahmatullah
