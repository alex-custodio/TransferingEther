package test;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
This code makes a simple ether transaction
 */
public class Transaction {

    public final static String PRIVATE_KEY = "";
    public final static BigInteger GAS_PRICE = BigInteger.valueOf(2000000000L);
    public final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    public final static String RECIPIENT = "";
    public static void main(String[] args) {
        try {
            new Transaction();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Transaction() throws Exception {
        Web3j web3j = Web3j.build(new HttpService(""));
        TransactionManager transactionManager = new RawTransactionManager(web3j, getCredentialsFromPrivateKey());
        Transfer transfer = new Transfer(web3j, transactionManager);
        TransactionReceipt transactionReceipt = transfer.sendFunds(RECIPIENT, BigDecimal.TEN, Convert.Unit.ETHER, GAS_PRICE, GAS_LIMIT).send();
    }
    public static Credentials getCredentialsFromPrivateKey(){
        return Credentials.create(PRIVATE_KEY);
    }
}
