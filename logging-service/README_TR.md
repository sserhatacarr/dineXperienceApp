# Hata Kayıt Servisi

Bu, Spring Boot uygulaması için bir hata kayıt servisidir. Mesaj tüketimi için Apache Kafka ve veri depolama için MongoDB kullanır. Servis, Kafka'dan hata günlüklerini tüketmek, bunları MongoDB'de saklamak ve günlükleri almak için bir API sağlamak üzere tasarlanmıştır.

## Proje Yapısı

Proje, dört ana pakete ayrılmıştır:

1. `com.serhatacarr.loggingservice.controller`: Bu paket, hata günlüklerini almak için bir REST API sunan `ErrorLogController` sınıfını içerir.

2. `com.serhatacarr.loggingservice.repository`: Bu paket, `MongoRepository`'yi genişleten `ErrorLogRepository` arayüzünü içerir. Bu arayüz, MongoDB'deki `ErrorLog` belgeleri üzerinde CRUD işlemleri için kullanılır.

3. `com.serhatacarr.loggingservice.service`: Bu paket, Kafka konusundan mesajları tüketen ve bunları MongoDB'de `ErrorLog` belgeleri olarak kaydeden `KafkaConsumerService` sınıfını içerir.

4. `com.serhatacarr.loggingservice.entity`: Bu paket, MongoDB'deki hata günlüğü belgelerini temsil eden `ErrorLog` sınıfını içerir.

## Kullanım

### Kafka Tüketicisi

`KafkaConsumerService` sınıfı `@Service` ve `@Slf4j` (loglama için) ile etiketlenmiştir. Kafka konusu "errorLog"dan mesajları tüketen `consume` adında `@KafkaListener` ile etiketlenmiş bir metodu vardır. Tüketilen mesaj, MongoDB'de bir `ErrorLog` belgesi olarak kaydedilir.

### Hata Günlüğü Deposu

`ErrorLogRepository` arayüzü, `MongoRepository<ErrorLog, String>`'i genişletir, bu da MongoDB'deki `ErrorLog` belgeleri üzerinde CRUD işlemleri için metotlar sağlar.

### Hata Günlüğü Kontrolörü

`ErrorLogController` sınıfı `@RestController` ve `@RequestMapping("/api/v1/error-logs")` ile etiketlenmiştir. MongoDB'den tüm `ErrorLog` belgelerini alıp bir liste olarak döndüren `findAll` adında `@GetMapping` ile etiketlenmiş bir metodu vardır.

### Hata Günlüğü Varlık

`ErrorLog` sınıfı `@Document(collection = "errorlogdoc")`, `@Getter`, `@Setter`, `@AllArgsConstructor`, `@NoArgsConstructor`, ve `@Builder` ile etiketlenmiştir. MongoDB'deki hata günlüğü belgelerini temsil eder.

## Kurulum

Bu servisi kullanmak için, çalışan bir Apache Kafka ve MongoDB örneğine ihtiyacınız vardır. Ayrıca, uygulamanın özellikler dosyasında Kafka konusu ve MongoDB bağlantı detaylarını yapılandırmanız gerekmektedir.

## Uygulamanın Çalıştırılması

Uygulamayı aşağıdaki komutla çalıştırabilirsiniz:

```bash
mvn spring-boot:run
```

Uygulama çalıştığında, API'ye `http://localhost:8080/api/v1/error-logs` adresinden erişebilirsiniz.

## İletişim

### Serhat Acar

<a href="https://github.com/sserhatacarr" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:sserhatacarr@gmail.com?subject = Geri Bildirim&body = Mesaj">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=gmail style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/sserhatacarr" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  

## Talenthub Bootcamp - N11 & Patika

<div align="center">
  <a href="https://www.n11.com/">
    <img src="../img/n11-logo.png" alt="Logo" width="220" height="140">
  </a>

<h3 align="center">Şirket: N11.com</h3>
</div>

<div align="center">
  <a href="https://www.patika.dev/">
    <img src="../img/patika-logo.png" alt="Logo" width="350" height="300">
  </a>
<h3 align="center">Organizatör: Patika.dev</h3>   
</div>
