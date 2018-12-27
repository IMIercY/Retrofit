package kh.com.gbstech.testfeature.Model;

public class RetrofitUser {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private RetrofitUser_Address address;



    public RetrofitUser_Address getAddress() {
        return address;
    }


    public RetrofitUser(Integer id, String name, String username, String email, String street, String suite, String city, String zipcode, String lat, String lng) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public RetrofitUser () {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   public class RetrofitUser_Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
       private RetrofitUser_geo geo;

       public RetrofitUser_geo getGeo() {
           return geo;
       }



        public RetrofitUser_Address(String street, String suite, String city, String zipcode) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
        }

        public RetrofitUser_Address () {

        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
    }

    public class RetrofitUser_geo {
        public RetrofitUser_geo(String lat, String lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public RetrofitUser_geo () {

        }

        public String getLat() {

            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        private String lat;
        private String lng;

    }
}
