package app.services;

import app.contracts.VoteManager;
import app.domain.Ballot;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class BallotStartupServices {

    VoteManager voteManager;

    public BallotStartupServices(@Value("${blockchain.contract}")String contractAddress, @Value("${blockchain.address}") String blockchainAddress, @Value("${blockchain.account}") String account ) {
        System.out.println(contractAddress);
        System.out.println(blockchainAddress);
        System.out.println(account);
        Web3j web3j = Web3j.build(new HttpService(blockchainAddress));

        TransactionManager transactionManager = new ClientTransactionManager(web3j, account);
        voteManager = VoteManager.load(contractAddress, web3j, new ClientTransactionManager(web3j,account),new DefaultGasProvider() );


    }

    public void startTimerForBallot(Ballot ballot) {
        BigInteger nextIndex = BigInteger.ZERO;

        System.out.println("Started Timer");
        BallotTimer timer = new BallotTimer(this, ballot);
        timer.start();
    }


    public void startBallot(Ballot ballot) {
        try {
            BigInteger nextIndex = BigInteger.ZERO;
            try{
                while(true){
                    Tuple3<byte[], Boolean, BigInteger> tmp = voteManager.ballots(nextIndex).send();
                    if(tmp == null){
                        break;
                    }
                    nextIndex = nextIndex.add(BigInteger.ONE);
//                    System.out.println(nextIndex);
                }
            }catch (Exception e){
                System.out.println("Found id");
            }

            System.out.println("Index:" + nextIndex);

            ballot.setId(nextIndex);

            RemoteCall<TransactionReceipt> call = voteManager.createBallot(stringToBytes32(ballot.getName()),ballot.getParticipants().getCandidates().stream().map(x -> stringToBytes32(x.getName())).collect(Collectors.toList()),
                    ballot.getParticipants().getUsers().stream().map(x -> BigInteger.valueOf(x.getId())).collect(Collectors.toList()));
            call.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endBallot(Ballot ballot) {
        try {
            voteManager.endBallot(ballot.getId()).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        return hex.toString() + "".join("", Collections.nCopies(32 - (hex.length() / 2), "00"));
    }

    public static byte[] stringToBytes32(String string) {
        byte[] byteValue = string.getBytes();
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        return byteValueLen32;
    }
}
