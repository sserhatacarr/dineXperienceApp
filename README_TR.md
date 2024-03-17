# Dine Experience Uygulaması

[İngilizce README'ye git](README.md)

Dine Experience Uygulaması, N11 TalentHub Backend Bootcamp için geliştirilen kapsamlı bir projedir. Bu uygulama, mikroservis mimarisi kullanılarak oluşturulmuştur ve `discovery-server`, `api-gateway`, `user-service` ve `restaurant-service` olmak üzere dört ana modülden oluşmaktadır. `discovery-server`, servisler arasındaki etkin iletişimi sağlayan bir servis kayıt mekanizması olarak işlev görür. `api-gateway`, tüm istemci isteklerinin tek giriş noktası olarak hizmet verir ve bu istekleri uygun servise yönlendirir. `user-service`, kullanıcıları ve restoranlar için kullanıcı yorumlarını yönetir, kullanıcı kaydı, yorum gönderme işlevlerini sunar. `restaurant-service`, restoranlarla ilgili tüm işlemleri yönetir, restoran kaydı ve listeleme dahil olmak üzere, tüm restoran verileri Apache Solr'da saklanır ve sorgular da Solr'a yapılır ve  ve kullanıcının konumuna ve restoranın puanına dayalı kişiselleştirilmiş restoran önerileri sağlama gibi işlevler sunar. Bu depodaki her servisin kendi README.md dosyası vardır ve bu dosyalar proje hakkında ayrıntılar sağlar.

## Servisler

- [Discovery Server](./discovery-server/README.md): Servis keşfi ve kaydı sağlayan bir Spring Boot uygulamasıdır. Netflix Eureka'yı servisleri kaydetmek ve keşfetmek için kullanır. Discovery Servisi, tüm istemciler için tek giriş noktasıdır. İstekleri uygun servise yönlendirir.

- [API Gateway](./api-gateway/README.md): Kullanıcıları ve restoranları yönetmek için bir RESTful API sağlayan bir Spring Boot uygulamasıdır. Kullanıcıları ve restoranları oluşturma, alama, güncelleme ve silme işlemlerini içerir. API Gateway, tüm istemciler için tek giriş noktasıdır. İstekleri uygun servise yönlendirir. Ayrıca kullanıcıları doğrulama ve yetkilendirme yolu da sağlar.

- [User Service](./user-service/README.md): Kullanıcıları ve kullanıcı yorumlarını yönetmek için bir RESTful API sağlayan bir Spring Boot uygulamasıdır. Kullanıcıları ve kullanıcı yorumlarını oluşturma, alama, güncelleme ve silme işlemlerini içerir. Her kullanıcının ilişkilendirilmiş enlem ve boylam değerleri vardır. Kullanıcı yorumlarının 1 ile 5 arasında bir puanı vardır.

- [Restaurant Service](./restaurant-service/README.md): Restoranları yönetmek için bir RESTful API sağlayan bir Spring Boot uygulamasıdır. Restoranları oluşturma, alama, güncelleme ve silme işlemlerini içerir. Her restoranın ilişkilendirilmiş enlem ve boylam değerleri vardır. Restoran verileri Apache Solr'da saklanır ve sorgular da Solr'a yapılır. Servis ayrıca, kullanıcının konumuna ve restoranın puanına dayalı restoran önerileri sağlayan bir API de sunar.