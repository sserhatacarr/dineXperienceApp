# Restaurant Servisi

[İngilizce README'ye git](README.md)

Restaurant Servisi, mikroservis mimarimizin önemli bir bileşenidir. Restaurant verilerini yönetmekten sorumludur ve restaurant bilgilerini oluşturma, güncelleme, silme ve almak için işlevler sağlar. Bu temel CRUD işlemlerinin yanı sıra, Restaurant Servisi ayrıca özel bir öneri özelliği sunar. Bu özellik, her bir restoran için bir puan hesaplar, bu hesaplama kullanıcının restorana olan mesafesi ve restoranın puanına dayanır, sadece kullanıcıdan 10 km yarıçapında olan restoranları dikkate alır. Puan, restoranın puanının (%70) ve kullanıcıya olan yakınlığının (%30) ağırlıklı bir kombinasyonudur. Servis daha sonra restoranları puanlarına göre azalan sırayla sıralar ve en üstteki 3 öneriyi döndürür. Bu öneri özelliği, kullanıcı konumu ve restoran puanlarına dayalı kişiselleştirilmiş restoran önerileri sağlayarak kullanıcı deneyimini artırır.

## User Client

`UserClient`, Restaurant Servisi içindeki bir Feign istemcisidir. Feign, HTTP istemcilerini yazmayı kolaylaştıran deklaratif bir web servisi istemcisidir. Mikroservis mimarimizde, servisler arası iletişimi kolaylaştırmak için kullanılır.

Bu bağlamda, `UserClient` User Servisi ile iletişim kurmak için kullanılır. Bir ana işlemi vardır:

- `getUserById(Long id)`: Bu işlem, User Servisi'nden belirli bir kullanıcının ID'sini alır. User Servisi'ne `GET /api/v1/users/{id}` isteği ile karşılık gelir.

Bu işlem, Restaurant Servisi'nin kullanıcılara restoran önerileri yönetme işlevi için hayati öneme sahiptir. Sistem bir kullanıcıya restoran önermek istediğinde, Restaurant Servisi, kullanıcının detaylarını, konum bilgileri dahil olmak üzere, User Servisi'nden almak için `UserClient`'ı kullanır. Bu, önerilerin kullanıcının konumuna dayalı olarak kişiselleştirilebilmesini sağlar, böylece kullanıcı deneyimi, özelleştirilmiş restoran önerileri sağlayarak artar.

## Restaurant Controller

RestaurantController, restaurant verilerini yönetmek için end pointlar sağlayan bir REST denetleyicisidir.

### End pointler

- `GET /api/v1/restaurants`: Bu end point, veritabanındaki tüm restoranları döndürür.

- `GET /api/v1/restaurants/{id}`: Bu end point, ID'si verilen bir restoranı döndürür.

- `POST /api/v1/restaurants`: Bu end point, veritabanına yeni bir restoran kaydeder. İstek gövdesinde bir `RestaurantSaveRequest` nesnesi kabul eder.

- `PUT /api/v1/restaurants`: Bu end point, veritabanındaki mevcut bir restoranı günceller. İstek gövdesinde bir `RestaurantUpdateRequest` nesnesi kabul eder.

- `DELETE /api/v1/restaurants/{id}`: Bu end point, ID'si verilen bir restoranı veritabanından siler.

### Yanıt

Bu end pointlerrıi yanıtları, bir `RestResponse` nesnesi içinde sarılır. Bu nesne aşağıdaki alanları içerir:

- `data`: Yanıtın verisi. Bir `RestaurantDTO` nesnesi, `RestaurantDTO` nesnelerinin bir listesi veya silme işlemi durumunda `null` olabilir.

- `message`: İşlemin sonucunu açıklayan bir mesaj.

`RestaurantDTO` nesnesi bir restoranı temsil eder ve aşağıdaki alanları içerir:

- `id`: Restoranın ID'si.
- `name`: Restoranın adı.
- `address`: Restoranın adresi.
- `phone`: Restoranın telefon numarası.
- `email`: Restoranın e-postası.
- `description`: Restoranın açıklaması.
- `website`: Restoranın web sitesi.
- `workingHours`: Restoranın çalışma saatleri.
- `latitude`: Restoranın konumunun enlemi.
- `longitude`: Restoranın konumunun boylamı.
- `restaurantRate`: Restoranın puanı.
- `status`: Restoranın durumu.

## Recommendation Controller

Recommendation Controller, bir kullanıcı için restoran önerilerini almak için bir end point sağlayan bir REST denetleyicisidir.

### End point

- `GET /api/v1/recommendations/{userId}`
  Bu end point, belirtilen `userId`'ye sahip kullanıcı için bir dizi önerilen restoranı döndürür. Öneriler, kullanıcının konumu ve restoranların puanlarına dayalı olarak hesaplanır.

### Yanıt

Yanıt, her biri önerilen bir restoranı temsil eden `RestaurantWithScoreDTO` nesnelerinin bir listesidir. Her nesne aşağıdaki alanları içerir:

- `id`: Restoranın ID'si.
- `name`: Restoranın adı.
- `address`: Restoranın adresi.
- `phone`: Restoranın telefon numarası.
- `email`: Restoranın e-postası.
- `description`: Restoranın açıklaması.
- `website`: Restoranın web sitesi.
- `workingHours`: Restoranın çalışma saatleri.
- `latitude`: Restoranın konumunun enlemi.
- `longitude`: Restoranın konumunun boylamı.
- `restaurantRate`: Restoranın puanı.
- `score`: Restoranın, kullanıcıdan olan mesafesi ve puanına dayalı olarak hesaplanan puanı.
- `distance`: Restoranın kullanıcıdan olan mesafesi.
- `status`: Restoranın durumu.

Liste, `score` alanına göre azalan sırayla sıralanır, bu yüzden listenin ilk restoranı en çok önerilen restorandır.

## Öneri Algoritması Açıklaması

Öneri algoritması, her bir restoran için bir puan hesaplar, bu hesaplama kullanıcının restorana olan mesafesi ve restoranın puanına dayanır. Algoritma, sadece kullanıcıdan 10 km yarıçapında olan restoranları dikkate alır.

Puan aşağıdaki şekilde hesaplanır:

- Puanın %70'i restoranın puanından gelir.
- Puanın %30'u restoranın kullanıcıdan olan mesafesinden gelir. Restoran ne kadar yakınsa, bu puanın bu kısmı o kadar yüksek olur.
  Puanlar hesaplandıktan sonra, algoritma restoranları puanlarına göre azalan sırayla sıralar ve en üstteki 3'ü döndürür.
