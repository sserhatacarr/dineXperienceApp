# Kullanıcı Servisi

[İngilizce README'ye git](README.md)

Kullanıcı Servisi, mikroservis mimarimizin önemli bir bileşenidir. Kullanıcı verilerini yönetmekten sorumludur ve kullanıcı bilgilerini oluşturma, güncelleme, silme ve almak için işlevler sağlar. Bu temel CRUD işlemlerinin yanı sıra, Kullanıcı Servisi ayrıca restoranlar için kullanıcı yorumlarını da yönetir. Her yorum, 1 ile 5 arasında bir puan içerir. Kullanıcı Servisi, kullanıcıların restoranlar hakkındaki görüşlerini ve deneyimlerini paylaşmalarına izin vererek kullanıcı deneyimini artırır.

## Restaurant Client

`RestaurantClient`, Kullanıcı Servisi'ndeki bir Feign istemcisidir. Feign, HTTP istemcilerini yazmayı kolaylaştıran deklaratif bir web servisi istemcisidir. Mikroservis mimarimizde, servisler arası iletişimi sağlamak için kullanılır.

Bu durumda, `RestaurantClient` Restaurant Servisi ile iletişim kurmak için kullanılır. İki ana işlemi vardır:

- `getAllRestaurants()`: Bu işlem, Restaurant Servisi'nden tüm restoranları alır. Restaurant Servisi'ne `GET /api/v1/restaurants` isteği ile karşılık gelir.

- `getRestaurantById(String id)`: Bu işlem, Restaurant Servisi'nden belirli bir restoranı ID'si ile alır. Restaurant Servisi'ne `GET /api/v1/restaurants/{id}` isteği ile karşılık gelir.

Bu işlemler, Kullanıcı Servisi'nin restoranlar için kullanıcı yorumlarını yönetmesi için hayati öneme sahiptir. Bir kullanıcı bir restoranı yorumlamak istediğinde, Kullanıcı Servisi, restoranın detaylarını Restaurant Servisi'nden almak için `RestaurantClient`'ı kullanır. Bu, kullanıcıların sadece mevcut restoranları yorumlayabileceğini ve Kullanıcı Servisi'nin yorumlanan restoranlar hakkında güncel bilgileri gösterebileceğini garanti eder.

## User Controller

`UserController`, kullanıcı verilerini yönetmek için endpointler sağlayan bir REST controller'dır.

### Endpoints

- `GET /api/v1/users`: Bu endpoint, veritabanındaki tüm kullanıcıları döndürür.

- `GET /api/v1/users/{id}`: Bu endpoint, ID'si ile bir kullanıcıyı döndürür.

- `POST /api/v1/users`: Bu endpoint, veritabanına yeni bir kullanıcı kaydeder. İstek gövdesinde bir `UserSaveRequest` nesnesi kabul eder.

- `PUT /api/v1/users/{debugId}`: Bu endpoint, veritabanındaki mevcut bir kullanıcıyı günceller. İstek gövdesinde bir `UserUpdateRequest` nesnesi kabul eder.

- `DELETE /api/v1/users/{id}`: Bu endpoint, ID'si ile veritabanından bir kullanıcıyı siler.

### Yanıt

Bu endpointlerden gelen yanıtlar, bir `RestResponse` nesnesi içinde sarılır. Bu nesne aşağıdaki alanları içerir:

- `data`: Yanıtın verisi. Bir `UserDTO` nesnesi, bir `UserDTO` nesneleri listesi veya bir silme işlemi durumunda `null` olabilir.

- `message`: İşlemin sonucunu açıklayan bir mesaj.

`UserDTO` nesnesi bir kullanıcıyı temsil eder ve aşağıdaki alanları içerir:

- `id`: Kullanıcının ID'si.
- `name`: Kullanıcının adı.
- `email`: Kullanıcının e-postası.
- `latitude`: Kullanıcının konumunun enlemi.
- `longitude`: Kullanıcının konumunun boylamı.


## User Review Controller

`UserReviewController`, kullanıcı yorumlarını yönetmek için endpointler sağlayan bir REST controller'dır.

### Endpoints

- `GET /api/v1/users/reviews/{id}`: Bu endpoint, ID'si ile bir kullanıcı yorumunu döndürür.

- `POST /api/v1/users/reviews`: Bu endpoint, yeni bir kullanıcı yorumu oluşturur. İstek gövdesinde bir `UserReviewSaveRequest` nesnesi kabul eder.

- `GET /api/v1/users/reviews/all`: Bu endpoint, tüm kullanıcı yorumlarını döndürür.
- `GET /api/v1/users/reviews/user/{userId}`: Bu endpoint, kullanıcı ID'si ile kullanıcı yorumlarını döndürür.

- `GET /api/v1/users/reviews/restaurant/{restaurantId}`: Bu endpoint, restoran ID'si ile kullanıcı yorumlarını döndürür.

- `PUT /api/v1/users/reviews`: Bu endpoint, bir kullanıcı yorumunu düzenler. İstek gövdesinde bir `UserReviewUpdateRequest` nesnesi kabul eder.

- `DELETE /api/v1/users/reviews/{id}`: Bu endpoint, ID'si ile bir kullanıcı yorumunu siler.

### Yanıt

Bu endpointlerden gelen yanıtlar, bir `RestResponse` nesnesi içinde sarılır. Bu nesne aşağıdaki alanları içerir:

- `data`: Yanıtın verisi. Bir `UserReviewDetailDTO` nesnesi, bir `UserReviewDetailDTO` nesneleri listesi veya bir silme işlemi durumunda `null` olabilir.

- `message`: İşlemin sonucunu açıklayan bir mesaj.

`UserReviewDetailDTO` nesnesi bir kullanıcı yorumunu temsil eder ve aşağıdaki alanları içerir:

- `id`: Kullanıcı yorumunun ID'si.
- `userId`: Yorumu yapan kullanıcının ID'si.
- `restaurantId`: Yorum yapılan restoranın ID'si.
- `score`: Kullanıcı tarafından verilen puan.
- `text`: Yorumun metni.

## Testler

Kullanıcı Servisi için birim ve entegrasyon testleri sağlanmıştır. Bu testler, servisin veritabanı ile etkileşimde bulunurken ve HTTP isteklerini işlerken beklendiği gibi işlev gördüğünü garanti eder.