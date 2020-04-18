package android.example.musicalstructureapp.modals;


public class RadioChannelModal {
    String radioChannelName,radioName;

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioChannelName) {
        this.radioName = radioChannelName;
    }

    public String getRadioChannelName() {
        return radioChannelName;
    }

    public void setRadioChannelName(String radioChannelName) {
        this.radioChannelName = radioChannelName;
    }

    public RadioChannelModal(String radioChannelName,String radioName) {
        this.radioChannelName = radioChannelName;
        this.radioName = radioName;
    }
}