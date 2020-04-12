package berger.earthquakes;


public class CurrentEarthquakes
{
    Feature[] features;

    Metadata metadata;

    String[] bbox;

    String type;

    public Feature[] getFeatures()
    {
        return features;
    }

    public void setFeatures(Feature[] features)
    {
        this.features = features;
    }

    public Metadata getMetadata()
    {
        return metadata;
    }

    public void setMetadata(Metadata metadata)
    {
        this.metadata = metadata;
    }

    public String[] getBbox()
    {
        return bbox;
    }

    public void setBbox(String[] bbox)
    {
        this.bbox = bbox;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [features = " + features + ", metadata = " + metadata + ", bbox = " + bbox + ", type = " + type + "]";
    }


    public class Feature
    {
         Geometry geometry;

         String id;

         String type;

         Properties properties;

        public Geometry getGeometry()
        {
            return geometry;
        }

        public void setGeometry(Geometry geometry)
        {
            this.geometry = geometry;
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public String getType()
        {
            return type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        public Properties getProperties()
        {
            return properties;
        }

        public void setProperties(Properties properties)
        {
            this.properties = properties;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [geometry = " + geometry + ", id = " + id + ", type = " + type + ", properties = " + properties + "]";
        }
    }


    public class Geometry
    {
        private String[] coordinates;

        private String type;

        public String[] getCoordinates()
        {
            return coordinates;
        }

        public void setCoordinates(String[] coordinates)
        {
            this.coordinates = coordinates;
        }

        public String getType()
        {
            return type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [coordinates = " + coordinates + ", type = " + type + "]";
        }
    }


    public class Properties
    {
        private String dmin;

        private String code;

        private String sources;

        private String tz;

        private String type;

        private String title;

        private String magType;


        private String sig;

        private String tsunami;

        private String mag;


        private String gap;

        private String rms;

        private String place;

        private String net;

        private String types;

        private String felt;

        private String cdi;

        private String url;

        private String ids;

        private String time;

        private String detail;

        private String updated;

        private String status;

        public String getDmin()
        {
            return dmin;
        }

        public void setDmin(String dmin)
        {
            this.dmin = dmin;
        }

        public String getCode()
        {
            return code;
        }

        public void setCode(String code)
        {
            this.code = code;
        }

        public String getSources()
        {
            return sources;
        }

        public void setSources(String sources)
        {
            this.sources = sources;
        }

        public String getTz()
        {
            return tz;
        }

        public void setTz(String tz)
        {
            this.tz = tz;
        }


        public String getType()
        {
            return type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getMagType()
        {
            return magType;
        }

        public void setMagType(String magType)
        {
            this.magType = magType;
        }



        public String getSig()
        {
            return sig;
        }

        public void setSig(String sig)
        {
            this.sig = sig;
        }

        public String getTsunami()
        {
            return tsunami;
        }

        public void setTsunami(String tsunami)
        {
            this.tsunami = tsunami;
        }

        public String getMag()
        {
            return mag;
        }

        public void setMag(String mag)
        {
            this.mag = mag;
        }


        public String getGap()
        {
            return gap;
        }

        public void setGap(String gap)
        {
            this.gap = gap;
        }

        public String getRms()
        {
            return rms;
        }

        public void setRms(String rms)
        {
            this.rms = rms;
        }

        public String getPlace()
        {
            return place;
        }

        public void setPlace(String place)
        {
            this.place = place;
        }

        public String getNet()
        {
            return net;
        }

        public void setNet(String net)
        {
            this.net = net;
        }

        public String getTypes()
        {
            return types;
        }

        public void setTypes(String types)
        {
            this.types = types;
        }

        public String getFelt()
        {
            return felt;
        }

        public void setFelt(String felt)
        {
            this.felt = felt;
        }

        public String getCdi()
        {
            return cdi;
        }

        public void setCdi(String cdi)
        {
            this.cdi = cdi;
        }

        public String getUrl()
        {
            return url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public String getIds()
        {
            return ids;
        }

        public void setIds(String ids)
        {
            this.ids = ids;
        }

        public String getTime()
        {
            return time;
        }

        public void setTime(String time)
        {
            this.time = time;
        }

        public String getDetail()
        {
            return detail;
        }

        public void setDetail(String detail)
        {
            this.detail = detail;
        }

        public String getUpdated()
        {
            return updated;
        }

        public void setUpdated(String updated)
        {
            this.updated = updated;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

    }


    public class Metadata
    {
        private String generated;

        private String count;

        private String api;

        private String title;

        private String url;

        private String status;

        public String getGenerated()
        {
            return generated;
        }

        public void setGenerated(String generated)
        {
            this.generated = generated;
        }

        public String getCount()
        {
            return count;
        }

        public void setCount(String count)
        {
            this.count = count;
        }

        public String getApi()
        {
            return api;
        }

        public void setApi(String api)
        {
            this.api = api;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getUrl()
        {
            return url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [generated = " + generated + ", count = " + count + ", api = " + api + ", title = " + title + ", url = " + url + ", status = " + status + "]";
        }
    }

}