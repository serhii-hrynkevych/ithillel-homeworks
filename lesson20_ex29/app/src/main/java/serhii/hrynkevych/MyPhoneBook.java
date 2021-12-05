package serhii.hrynkevych;

import java.util.*;

public class MyPhoneBook {
    private final List<PhoneRecord> phoneRecordList;

    public MyPhoneBook() {
        this.phoneRecordList = new ArrayList<>();
    }

    public List<PhoneRecord> getPhoneRecordList() {
        return phoneRecordList;
    }

    public int getSize() {
        return phoneRecordList.size();
    }

    public boolean addPhoneNumber(String inputLine) {
        String[] splitInputLine = splitInputLine(inputLine);
        boolean checkingInputLine = checkInputLine(splitInputLine);
        if (checkingInputLine) {
            phoneRecordList.add(new PhoneRecord(splitInputLine[0], splitInputLine[1]));
            return true;
        } else {
            return false;
        }
    }

    public String[] splitInputLine(String inputLine) {
        return inputLine.split(", ");
    }

    public boolean checkInputLine(String[] splitInputLine) {
        return splitInputLine.length == 2;
    }

    public void printPhoneBook() {
        if (this.phoneRecordList.size() == 0) {
            System.out.println("Телефоннаю книга пуста\n");
        } else {
            for (PhoneRecord phoneRecord : this.phoneRecordList) {
                System.out.println(phoneRecord.getName() + " : " + phoneRecord.getPhone());
            }
        }
    }

    public void sortByName() {
        this.phoneRecordList.sort(new Comparator<PhoneRecord>() {
            @Override
            public int compare(PhoneRecord o1, PhoneRecord o2) {
                String n1 = o1.getName();
                String n2 = o2.getName();
                return n1.compareTo(n2);
            }
        });
//        phoneRecordList.sort(Comparator.comparing(PhoneRecord::getName));
    }

    public void sortByPhoneNumber() {
        this.phoneRecordList.sort((o1, o2) -> {
            String n1 = o1.getPhone();
            String n2 = o2.getPhone();
            return n1.compareTo(n2);
        });
    }

    static class PhoneRecord{
        private String name;
        private String phone;

        public PhoneRecord(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "\nPhoneRecord{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    "}";
        }
    }
}
