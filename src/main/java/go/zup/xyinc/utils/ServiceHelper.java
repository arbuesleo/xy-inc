package go.zup.xyinc.utils;

public class ServiceHelper{
	
	public static Message buildErrorResponse(String msg, String detalhe){
		Message returnMsg = new Message<>();
		returnMsg.addField("mensagem", msg);
		returnMsg.addField("detalhe", detalhe);
		return returnMsg;
	}
	
	public static Message buildErrorResponse(Exception e){
		return buildErrorResponse(e.getLocalizedMessage(), e.getMessage());
	}
}
