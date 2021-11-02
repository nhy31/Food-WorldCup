package ddwu.mobile.finalproject.ma02_20180963;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class NaverRestaurantXmlParser {

    private XmlPullParser parser;

    public enum TagType { NONE, TITLE, LINK, CATEGORY, DESCRIPTION, TELEPHONE, ADDRESS, ROADADDRESS, MAPX, MAPY };

    private final static String FAULT_RESULT = "faultResult";
    private final static String ITEM_TAG = "item";
    private final static String TITLE_TAG = "title";
    private final static String LINK_TAG = "link";
    private final static String CATEGORY_TAG = "category";
    private final static String DESCRIPTION_TAG = "description";
    private final static String TELEPHONE_TAG = "telephone";
    private final static String ADDRESS_TAG = "address";
    private final static String ROADADDRESS_TAG = "roadAddress";
    private final static String MAPX_TAG = "mapx";
    private final static String MAPY_TAG = "mapy";


        public NaverRestaurantXmlParser() {
            // xml 파서 관련 변수들은 필요에 따라 멤버변수로 선언 후 생성자에서 초기화
//        파서 준비
            XmlPullParserFactory factory = null;

//        파서 생성
            try {
                factory = XmlPullParserFactory.newInstance();
                parser = factory.newPullParser();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

        }

        public ArrayList<NaverRestaurantDto> parse(String xml) {

            ArrayList<NaverRestaurantDto> resultList = new ArrayList();
            NaverRestaurantDto dto = null;
            TagType tagType = TagType.NONE;

            try {

                parser.setInput(new StringReader(xml));
                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.END_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            if (parser.getName().equals(ITEM_TAG)) {
                                dto = new NaverRestaurantDto();
                            } else if (parser.getName().equals(TITLE_TAG)) {
                                if (dto != null) tagType = TagType.TITLE;
                            } else if (parser.getName().equals(LINK_TAG)) {
                                if (dto != null) tagType = TagType.LINK;
                            } else if (parser.getName().equals(CATEGORY_TAG)) {
                                if (dto != null) tagType = TagType.CATEGORY;
                            } else if (parser.getName().equals(DESCRIPTION_TAG)) {
                                if (dto != null) tagType = TagType.DESCRIPTION;
                            } else if (parser.getName().equals(TELEPHONE_TAG)) {
                                if (dto != null) tagType = TagType.TELEPHONE;
                            } else if (parser.getName().equals(ADDRESS_TAG)) {
                                if (dto != null) tagType = TagType.ADDRESS;
                            } else if (parser.getName().equals(ROADADDRESS_TAG)) {
                                if (dto != null) tagType = TagType.ROADADDRESS;
                            } else if (parser.getName().equals(MAPX_TAG)) {
                                if (dto != null) tagType = TagType.MAPX;
                            } else if (parser.getName().equals(MAPY_TAG)) {
                                if (dto != null) tagType = TagType.MAPY;
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if (parser.getName().equals(ITEM_TAG)) {
                                resultList.add(dto);
                                dto = null;
                            }
                            break;
                        case XmlPullParser.TEXT:
                            switch(tagType) {
                                case TITLE:
                                    dto.setTitle(parser.getText());
                                    break;
                                case LINK:
                                    dto.setLink(parser.getText());
                                    break;
                                case CATEGORY:
                                    dto.setCategory(parser.getText());
                                    break;
                                case DESCRIPTION:
                                    dto.setDescription(parser.getText());
                                    break;
                                case TELEPHONE:
                                    dto.setTelephone(parser.getText());
                                    break;
                                case ADDRESS:
                                    dto.setAddress(parser.getText());
                                    break;
                                case ROADADDRESS:
                                    dto.setRoadAddress(parser.getText());
                                    break;
                                case MAPX:
                                    dto.setMapx(Integer.parseInt(parser.getText()));
                                    break;
                                case MAPY:
                                    dto.setMapy(Integer.parseInt(parser.getText()));
                                    break;
                            }
                            tagType = TagType.NONE;
                            break;
                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultList;
        }
}


